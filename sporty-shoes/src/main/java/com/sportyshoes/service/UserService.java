package com.sportyshoes.service;

import com.sportyshoes.dto.ShoeDTO;
import com.sportyshoes.dto.UserDTO;
import com.sportyshoes.dto.UserRequestDTO;
import com.sportyshoes.dto.UserResponseDTO;
import com.sportyshoes.entity.User;
import com.sportyshoes.repository.UserRepository;
import com.sportyshoes.utils.RedisUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.sportyshoes.constants.AppConstants.INVALID_PASSWORD;
import static com.sportyshoes.constants.AppConstants.LOGIN_SUCCESS;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RedisUtility redisUtility;

    @Autowired
    public UserService(UserRepository userRepository, RedisUtility redisUtility) {
        this.userRepository = userRepository;
        this.redisUtility = redisUtility;
    }

    public ResponseEntity<UserResponseDTO> getAllUsers(User userDO, String sessionId) {
//        User session = (User) redisUtility.getValue(sessionId);
//        if(session == null || session.getRole() != 1) {
//            return ResponseEntity.notFound().build();
//        }
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = users.stream()
                .map(userDTO -> {
                    return new UserDTO(userDTO.getUserid(), userDTO.getName(),
                            userDTO.getEmail(), userDTO.getPhonenumber(),
                            userDTO.getRole());
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(new UserResponseDTO("Users found", true, userDTOs));
    }

    public ResponseEntity<UserResponseDTO> createUser(User user){
        List<User> usersFromDB = userRepository.findByEmail(user.getEmail());
        if(usersFromDB != null && usersFromDB.size() != 0){
            return ResponseEntity.
                    status(HttpStatus.CREATED).
                    body(new UserResponseDTO("User with email id already present. Please login to proceed.", true, null));
        }
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO(createdUser.getUserid(),
                createdUser.getName(), createdUser.getEmail(),
                createdUser.getPhonenumber(), createdUser.getRole());
        List<UserDTO> userDTOs = new ArrayList<>(1);
        userDTOs.add(userDTO);
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(new UserResponseDTO("User created", true, userDTOs));
    }

    public ResponseEntity<UserResponseDTO> loginUser(UserRequestDTO user){
        List<User> usersFromDB = userRepository.findByEmail(user.getEmail());
        if(usersFromDB == null || usersFromDB.size() == 0){
            return ResponseEntity.notFound().build();
        }
        User findUser = usersFromDB.get(1);
        if(findUser.getPassword().equals(user.getPassword())){
            String sessionId = UUID.randomUUID().toString();
            HttpHeaders headers = new HttpHeaders();
            headers.set("sessionId", sessionId);
            List<UserDTO> userDTOS = usersFromDB.stream()
                    .map(x -> {
                        return new UserDTO(x.getUserid(), x.getName(), x.getEmail(), x.getPhonenumber(), x.getRole());
                    })
                    .collect(Collectors.toList());
            ResponseEntity<UserResponseDTO> finalResponse = ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .body(new UserResponseDTO(LOGIN_SUCCESS, true, userDTOS));
//            redisUtility.setValue(sessionId, findUser);
            return finalResponse;
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new UserResponseDTO(INVALID_PASSWORD, false, null));
        }
    }


}
