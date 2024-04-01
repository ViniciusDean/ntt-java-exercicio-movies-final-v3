package com.example.academiacx.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "tb_genre")
public class GenreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String genreName;


    @Valid
    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<MovieModel> movies;


    @Valid
    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<FranchiseModel> franchise;

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

    public List<FranchiseModel> getFranchise() {
        return franchise;
    }

    public void setFranchise(List<FranchiseModel> franchise) {
        this.franchise = franchise;
    }
}
