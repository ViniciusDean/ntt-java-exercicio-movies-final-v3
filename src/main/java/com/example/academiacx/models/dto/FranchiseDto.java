package com.example.academiacx.models.dto;

import com.example.academiacx.models.FranchiseModel;
import com.example.academiacx.models.GenreModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.StudioModel;

import java.util.List;

public class FranchiseDto {
    private Long id;
    private String name;
    private GenreModel genre;
    private StudioModel studio;
    private List<MovieModel> movies;

    public FranchiseDto(FranchiseModel franchiseModel){
        this.id = franchiseModel.getId();
        this.name = franchiseModel.getName();
        this.genre = franchiseModel.getGenre();
        this.studio = franchiseModel.getStudio();
        this.movies = franchiseModel.getMovies();
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

    public GenreModel getGenre() {
        return genre;
    }

    public void setGenre(GenreModel genre) {
        this.genre = genre;
    }

    public StudioModel getStudio() {
        return studio;
    }

    public void setStudio(StudioModel studio) {
        this.studio = studio;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
