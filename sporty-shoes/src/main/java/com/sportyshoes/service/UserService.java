package com.sportyshoes.service;

import com.sportyshoes.dto.UserRequestDTO;
import com.sportyshoes.dto.UserResponseDTO;
import com.sportyshoes.entity.User;
import com.sportyshoes.repository.UserRepository;
import com.sportyshoes.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sportyshoes.constants.AppConstants.INVALID_PASSWORD;
import static com.sportyshoes.constants.AppConstants.LOGIN_SUCCESS;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserResponseDTO> getAllUsers(User user) {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(new UserResponseDTO(null, users, "Users found", true));
    }

    public ResponseEntity<User> createUser(User user){
        User createdUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    public ResponseEntity<UserResponseDTO> loginUser(UserRequestDTO user){
        User findUser = userRepository.findByEmail(user.getEmail());
        if(findUser == null){
            return ResponseEntity.notFound().build();
        }
        if(findUser.getPassword().equals(user.getPassword())){
            ResponseEntity<UserResponseDTO> finalResponse = ResponseEntity
                    .ok(new UserResponseDTO(findUser, null, LOGIN_SUCCESS, true));
            finalResponse.getHeaders().set("sessionId", "abcdefghijklmn");
            return finalResponse;
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new UserResponseDTO(null, null, INVALID_PASSWORD, false));
        }
    }


}
