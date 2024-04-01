package com.example.academiacx.models.dto;

import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.StreamingModel;
import com.example.academiacx.models.UserModel;

import java.util.List;

public class StreamingDto {
    private Long id;
    private String name;
    private String url;
    private List<MovieModel> movies;

    public StreamingDto(StreamingModel streamingModel) {

        this.id = streamingModel.getId();
        this.name = streamingModel.getName();
        this.url = streamingModel.getUrl();
        this.movies = streamingModel.getMovies();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
