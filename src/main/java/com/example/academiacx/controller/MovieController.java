package com.example.academiacx.controller;

import com.example.academiacx.facades.inter.ActorMovieFacade;
import com.example.academiacx.facades.inter.DirectorMovieFacade;
import com.example.academiacx.facades.inter.MovieFranchiseFacade;
import com.example.academiacx.facades.inter.MovieStreamFacade;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.StreamingModel;
import com.example.academiacx.services.inter.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieStreamFacade movieStreamFacade;
    @Autowired
    private MovieFranchiseFacade movieFranchiseFacade;
    @Autowired
    private ActorMovieFacade actorMovieFacade;


        @GetMapping(value = "/list")
        public ResponseEntity<List<MovieModel>> findAll()
        {
            List<MovieModel> response = movieService.list();

            return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
        }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<MovieModel>> findById(@PathVariable Long id)
    {
        Optional<MovieModel> response = movieService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<MovieModel> save(@RequestBody MovieModel movieModel)
    {
        MovieModel response = movieService.create(movieModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<MovieModel> update(@RequestBody MovieModel movieModel)
    {
        MovieModel response = movieService.update(movieModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = movieService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
    @PutMapping("/{movieId}/setFranchise/{franchiseId}") // add filme para uma franquia
    public ResponseEntity<MovieModel> setFranchiseForMovie(@PathVariable Long movieId, @PathVariable Long franchiseId)
    {
        MovieModel response = movieFranchiseFacade.setFranchise(movieId, franchiseId);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
    @PutMapping("/{movieId}/setActor/{actorId}") //add ator a um filme
    public ResponseEntity<MovieModel> addActorToMovie(@PathVariable Long movieId, @PathVariable Long actorId)
    {
        MovieModel response = actorMovieFacade.addActorToMovie(movieId, actorId);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
    @PutMapping("/{movieId}/setStreaming/{streamingId}")
    public ResponseEntity<?> addMovieToStreaming(@PathVariable Long movieId, @PathVariable Long streamingId)
    {
        MovieModel response =  movieStreamFacade.setMovieStream(movieId, streamingId);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
    @DeleteMapping("{movieId}/removeStreaming/{streamingId}")
    public ResponseEntity<MovieModel> removeMovieFromStreaming(@PathVariable Long movieId, @PathVariable Long streamingId) {
        MovieModel response = movieStreamFacade.removeFromStreaming(streamingId, movieId);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

}
