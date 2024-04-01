package com.example.academiacx.facades.inter;

import com.example.academiacx.models.UserModel;

public interface UserFavoritesFacade {
    UserModel setFavoriteMovie(Long userId, Long movieId);
    UserModel setFavoriteDirector(Long userId, Long directorId);
}
