package com.example.academiacx.models.dto;

import com.example.academiacx.models.FranchiseModel;
import com.example.academiacx.models.GenreModel;
import com.example.academiacx.models.MovieModel;

import java.util.List;

public class GenreDto {
    private Long id;
    private String genreName;
    private List<MovieModel> movies;
    private List<FranchiseModel> franchise;


    public GenreDto(GenreModel genreModel){
        this.id = genreModel.getId();
        this.genreName = genreModel.getGenreName();
        this.movies = genreModel.getMovies();
        this.franchise = genreModel.getFranchise();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
