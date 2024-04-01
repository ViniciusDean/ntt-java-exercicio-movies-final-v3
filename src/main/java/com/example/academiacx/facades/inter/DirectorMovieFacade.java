package com.example.academiacx.facades.inter;

import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.MovieModel;

public interface DirectorMovieFacade {
    DirectorModel addDirectorToMovie(Long movieId, Long directorId);
}
