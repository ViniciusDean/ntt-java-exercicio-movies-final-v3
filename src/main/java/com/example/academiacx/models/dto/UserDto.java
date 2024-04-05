package com.example.academiacx.models.dto;

import com.example.academiacx.models.AddressModel;
import com.example.academiacx.models.UserModel;
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private AddressModel address;


    public UserDto() {
    }


    public UserDto(UserModel userModel) {

        this.id = userModel.getId();
        this.username = userModel.getUsername();
        this.email = userModel.getEmail();
        this.address = userModel.getAddress();
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
