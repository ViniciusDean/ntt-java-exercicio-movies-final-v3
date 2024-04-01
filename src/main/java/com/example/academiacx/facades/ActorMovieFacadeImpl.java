package com.example.academiacx.facades;

import com.example.academiacx.facades.inter.ActorMovieFacade;
import com.example.academiacx.models.ActorModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.repository.ActorRepository;
import com.example.academiacx.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorMovieFacadeImpl implements ActorMovieFacade {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Override
    public MovieModel addActorToMovie(Long movieId, Long actorId) {
        MovieModel movieModel = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie não encontrado"));

        ActorModel actorModel = actorRepository.findById(actorId)
                .orElseThrow(() -> new IllegalArgumentException("Actor não encontrado"));

        if (movieModel.getActors().contains(actorModel)) {
            throw new RuntimeException("Actor ja esta associado ao movie");
        }
        else {
            movieModel.getActors().add(actorModel);
            return movieRepository.save(movieModel);
        }
    }
}
