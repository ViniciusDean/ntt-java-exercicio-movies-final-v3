package com.example.academiacx.models.dto;

import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.UserModel;

import java.util.List;

public class UserBookmarkDto {



    private Long id;
    private String username;
    private List<MovieModel> favoriteMovies;
    private List<DirectorModel> favoriteDirectors;
    public UserBookmarkDto(UserModel userModel) {
        this.id = userModel.getId();
        this.username = userModel.getUsername();
        this.favoriteMovies = userModel.getFavoriteMovies();
        this.favoriteDirectors = userModel.getFavoriteDirectors();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<MovieModel> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(List<MovieModel> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public List<DirectorModel> getFavoriteDirectors() {
        return favoriteDirectors;
    }

    public void setFavoriteDirectors(List<DirectorModel> favoriteDirectors) {
        this.favoriteDirectors = favoriteDirectors;
    }
}
