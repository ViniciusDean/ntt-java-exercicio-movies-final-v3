package com.example.academiacx.facades;

import com.example.academiacx.facades.inter.UserFavoritesFacade;
import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.repository.DirectorRepository;
import com.example.academiacx.repository.MovieRepository;
import com.example.academiacx.repository.UserRepository;
import com.example.academiacx.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserFavoritesFacadeImpl implements UserFavoritesFacade {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Override
    public UserModel setFavoriteMovie(Long userId, Long movieId) {
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User nao encontrado"));

        MovieModel movieModel = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie nao encontrado"));

        if (userModel.getFavoriteMovies().contains(movieModel)) {
            throw new RuntimeException("Movie ja nos favoritos");
        }
        else {
            userModel.getFavoriteMovies().add(movieModel);
            return userRepository.save(userModel);
        }
    }
    public UserModel setFavoriteDirector(Long userId, Long directorId) {
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User não encontrado"));

        DirectorModel directorModel = directorRepository.findById(directorId)
                .orElseThrow(() -> new IllegalArgumentException("Director não encontrador"));

        if (userModel.getFavoriteDirectors().contains(directorModel)) {
            throw new RuntimeException("Director ja nos favoritos");
        }
        else {
            userModel.getFavoriteDirectors().add(directorModel);
            return userRepository.save(userModel);
        }

    }
}
