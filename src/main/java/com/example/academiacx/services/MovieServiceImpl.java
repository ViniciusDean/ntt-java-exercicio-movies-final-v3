package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.*;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.repository.*;
import com.example.academiacx.services.inter.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public List<MovieModel> list() {
        return movieRepository.findAll();
    }
    
    @Override
    public Optional<MovieModel> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public MovieModel create(MovieModel movieModel) {
        movieModel.setId(null);

        return movieRepository.save(movieModel);
    }

    @Override
    public MovieModel update(MovieModel movieModel) {
        if(movieModel.getId() == null || findById(movieModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return movieRepository.save(movieModel);
    }
    @Override
    public List<MovieModel> getMovie(Long id) {
        return (List<MovieModel>) movieRepository.getReferenceById(id);
    }
    public boolean delete(Long id) {

        MovieModel movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie não encontrado"));

        for (DirectorModel director : movie.getDirectors()) {
            director.getMovies().remove(movie);
            directorRepository.save(director);
        }
        for (UserModel user : movie.getUser()) {
            user.getFavoriteMovies().remove(movie);
            userRepository.save(user);
        }
        movieRepository.delete(movie);
        return true;
    }


}
