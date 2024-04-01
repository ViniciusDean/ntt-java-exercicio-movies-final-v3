package com.example.academiacx.models.dto;

import com.example.academiacx.models.FranchiseModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.StudioModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;

import java.util.List;

public class StudioDto {
    private Long id;
    private String name;

    private String country;

    private List<MovieModel> movies;
    private List<FranchiseModel> franchise;

    public StudioDto (StudioModel studioModel){
        this.id = studioModel.getId();
        this.name = studioModel.getName();
        this.country = studioModel.getCountry();
        this.movies = studioModel.getMovies();
        this.franchise = studioModel.getFranchise();
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }

    public List<FranchiseModel> getFranchise() {
        return franchise;
    }

    public void setFranchise(List<FranchiseModel> franchise) {
        this.franchise = franchise;
    }
}
