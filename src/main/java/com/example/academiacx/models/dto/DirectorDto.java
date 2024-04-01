package com.example.academiacx.models.dto;

import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.MovieModel;

import java.util.List;

public class DirectorDto {
    private Long id;
    private String name;
    private List<MovieModel> movies;

    public DirectorDto() {
    }


    public DirectorDto(DirectorModel directorModel) {

        this.id = directorModel.getId();
        this.name = directorModel.getName();
        this.movies = directorModel.getMovies();
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
