package com.sportyshoes.dto;

import com.sportyshoes.entity.User;
import com.sportyshoes.utils.BaseResponse;

import java.util.List;

public class UserResponseDTO extends BaseResponse {
    private User user;
    private List<User> users;

    public UserResponseDTO(User user, List<User> users, String message, boolean isSuccess) {
        super(message, isSuccess);
        this.user = user;
        this.users = users;
    }

    public UserResponseDTO() {
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
