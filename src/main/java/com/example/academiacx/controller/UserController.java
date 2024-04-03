package com.example.academiacx.controller;

import com.example.academiacx.facades.inter.UserFacade;
import com.example.academiacx.facades.inter.UserFavoritesFacade;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.StreamingModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.UserBookmarkDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.services.inter.UserService;
import com.example.academiacx.utils.MovieUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;
    @Autowired
    private UserService userService;
    @Autowired
    private UserFavoritesFacade userFavoritesFacade;

    @GetMapping(value = "/list")
    public ResponseEntity<? > findAll()
    {
        MovieUtil movieUtil ;
        try {
            return new ResponseEntity<> (userFacade.listUsers(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(MovieUtil.result(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value()), HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findbyId(@PathVariable Long id)
    {
        try {
            return new ResponseEntity<> (userFacade.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(MovieUtil.result(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value()), HttpStatus.UNPROCESSABLE_ENTITY);
        }


    }


    @GetMapping(value = "/listfavorites")
    public ResponseEntity<List<UserBookmarkDto>> getAllUserBookmarks() {
        List<UserBookmarkDto> userBookmarksDtoList = userService.getAllUserBookmarksDto();
        return ResponseEntity.ok(userBookmarksDtoList);
    }



    @PostMapping(value = "/save")
    public ResponseEntity<UserModel> save(@RequestBody UserModel userModel)
    {
        UserModel response = userService.create(userModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel)
    {
        UserModel response = userFacade.update(userModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = userService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
    @PutMapping("/{userId}/movie/{movieId}")
    public ResponseEntity<?> setFavoriteMovie(@PathVariable Long userId, @PathVariable Long movieId)
    {
        UserModel response =  userFavoritesFacade.setFavoriteMovie(userId, movieId);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
    @PutMapping("/{userId}/director/{directorId}")
    public ResponseEntity<?> setFavoriteDirector(@PathVariable Long userId, @PathVariable Long directorId)
    {
        UserModel response =  userFavoritesFacade.setFavoriteDirector(userId, directorId);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
}
