package com.example.academiacx.facades.inter;

import com.example.academiacx.models.AddressModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.AddressDto;
import com.example.academiacx.models.dto.UserBookmarkDto;
import com.example.academiacx.models.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserFacade {
    List<UserDto> listUsers();

    UserModel findById(Long id);
    List<UserBookmarkDto> getAllUserBookmarksDto();

    UserModel create(UserModel userModel);

    UserModel update(UserModel userModel);
    AddressDto saveAddress(AddressDto addressDto);
    void populatorUsers(  final UserModel users, final UserDto userDto );
    boolean delete(Long id);
}
