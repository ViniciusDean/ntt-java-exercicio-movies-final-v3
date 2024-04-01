package com.example.academiacx.facades.inter;

import com.example.academiacx.models.MovieModel;

public interface ActorMovieFacade {
    MovieModel addActorToMovie(Long movieId, Long actorId);

}
