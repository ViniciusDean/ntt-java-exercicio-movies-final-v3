package com.example.academiacx.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "tb_studio")
public class StudioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome do Estudio é obrigatório")
    private String name;

    private String country;

    @OneToMany(mappedBy = "studio")
    @JsonIgnore
    private List<MovieModel> movies;
    @Valid
    @JsonIgnore
    @OneToMany(mappedBy = "studio")
    private List<FranchiseModel> franchise;

    public Long getId() {
        return id;
    }

    public List<FranchiseModel> getFranchise() {
        return franchise;
    }

    public void setFranchise(List<FranchiseModel> franchise) {
        this.franchise = franchise;
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
}
