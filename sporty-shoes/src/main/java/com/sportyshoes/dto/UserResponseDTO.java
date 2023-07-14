package com.sportyshoes.dto;

import com.sportyshoes.entity.User;
import com.sportyshoes.utils.BaseResponse;

import java.util.List;

public class UserResponseDTO extends BaseResponse {
    private List<UserDTO> users;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String message, boolean isSuccess, List<UserDTO> users) {
        super(message, isSuccess);
        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
