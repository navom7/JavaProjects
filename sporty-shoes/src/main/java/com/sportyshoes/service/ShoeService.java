package com.sportyshoes.service;

import com.sportyshoes.dto.ShoeDTO;
import com.sportyshoes.dto.ShoeRequestDTO;
import com.sportyshoes.dto.ShoeResponseDTO;
import com.sportyshoes.entity.Shoe;
import com.sportyshoes.entity.User;
import com.sportyshoes.repository.ShoeRepository;
import com.sportyshoes.repository.ShoeRepository;
import com.sportyshoes.utils.BaseResponse;
import com.sportyshoes.utils.RedisUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sportyshoes.constants.AppConstants.INVALID_PASSWORD;
import static com.sportyshoes.constants.AppConstants.LOGIN_SUCCESS;

@Service
public class ShoeService {

    private final ShoeRepository shoeRepository;

    private final RedisUtility redisUtility;

    @Autowired
    public ShoeService(ShoeRepository shoeRepository, RedisUtility redisUtility) {
        this.shoeRepository = shoeRepository;
        this.redisUtility = redisUtility;
    }

    public ResponseEntity<ShoeResponseDTO> getAllShoes(Long userId) {
//        User session = (User) redisUtility.getValue(sessionId);

        List<Shoe> shoesResponse = shoeRepository.findAll();
        List<ShoeDTO> shoes = shoesResponse.stream()
                .map(shoe -> {
                    return new ShoeDTO(shoe.getShoeid(), shoe.getName(), shoe.getCategory(), shoe.getPrice());
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ShoeResponseDTO(null, shoes, "Shoes found", true));
    }

    public ResponseEntity<Shoe> createShoe(Shoe Shoe){
//        User session = (User) redisUtility.getValue(sessionId);
//        if(session == null || session.getRole() != 1) {
//            return ResponseEntity.badRequest().build();
//        }
        Shoe createdShoe = shoeRepository.save(Shoe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShoe);
    }


}
