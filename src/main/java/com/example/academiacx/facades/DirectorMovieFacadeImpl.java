package com.example.academiacx.facades;

import com.example.academiacx.facades.inter.DirectorMovieFacade;
import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.repository.DirectorRepository;
import com.example.academiacx.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorMovieFacadeImpl implements DirectorMovieFacade {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Override
    public DirectorModel addDirectorToMovie(Long movieId, Long directorId) {
        MovieModel movieModel = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie não encontrado"));

        DirectorModel directorModel = directorRepository.findById(directorId)
                .orElseThrow(() -> new IllegalArgumentException("Director não encontrado"));

        if (directorModel.getMovies().contains(movieModel)) {
            throw new RuntimeException("Movie ja esta associado ao director");
        }
        else {
            directorModel.getMovies().add(movieModel);
            return directorRepository.save(directorModel);
        }

    }
}
