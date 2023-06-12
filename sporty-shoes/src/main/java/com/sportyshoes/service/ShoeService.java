package com.sportyshoes.service;

import com.sportyshoes.dto.ShoeDTO;
import com.sportyshoes.dto.ShoeRequestDTO;
import com.sportyshoes.dto.ShoeResponseDTO;
import com.sportyshoes.entity.Shoe;
import com.sportyshoes.repository.ShoeRepository;
import com.sportyshoes.repository.ShoeRepository;
import com.sportyshoes.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sportyshoes.constants.AppConstants.INVALID_PASSWORD;
import static com.sportyshoes.constants.AppConstants.LOGIN_SUCCESS;

@Service
public class ShoeService {

    private final ShoeRepository shoeRepository;

    @Autowired
    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    public ResponseEntity<ShoeResponseDTO> getAllShoes() {
        List<Shoe> shoesResponse = shoeRepository.findAll();
        List<ShoeDTO> shoes = shoesResponse.stream()
        return ResponseEntity.ok(new ShoeResponseDTO(null, shoes, "Shoes found", true));
    }

    public ResponseEntity<Shoe> createShoe(Shoe Shoe){
        Shoe createdShoe = shoeRepository.save(Shoe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShoe);
    }


}
