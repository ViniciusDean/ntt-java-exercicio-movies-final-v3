package com.example.academiacx.models.dto;

import com.example.academiacx.models.ActorModel;
import com.example.academiacx.models.AddressModel;
import com.example.academiacx.models.MovieModel;

import java.util.List;

public class ActorDto {

    private Long id;
    private String name;
    private List<MovieModel> movies;

    public ActorDto (ActorModel actorModel){
        this.id = actorModel.getId();
        this.name = actorModel.getName();
        this.movies = actorModel.getMovies();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
