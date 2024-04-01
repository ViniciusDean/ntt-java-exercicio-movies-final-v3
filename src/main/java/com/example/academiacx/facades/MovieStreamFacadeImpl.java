package com.example.academiacx.facades;

import com.example.academiacx.facades.inter.MovieStreamFacade;
import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.StreamingModel;
import com.example.academiacx.repository.MovieRepository;
import com.example.academiacx.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieStreamFacadeImpl implements MovieStreamFacade {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    private StreamingRepository streamingRepository;
    @Override
    public MovieModel setMovieStream(Long movieId, Long streamingId ) {
        StreamingModel streamingModel = streamingRepository.findById(streamingId)
                .orElseThrow(() -> new IllegalArgumentException("Streaming não encontrado"));

        MovieModel movieModel = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie não encontrado"));
        if (movieModel.getStreaming().contains(streamingModel)) {
            throw new RuntimeException("Streaming ja adicionado");
        }
        else {
            movieModel.getStreaming().add(streamingModel);
            return movieRepository.save(movieModel);
        }
    }
    public MovieModel removeFromStreaming(Long streamingId, Long movieId) {
        StreamingModel streamingModel = streamingRepository.findById(streamingId)
                .orElseThrow(() -> new IllegalArgumentException("Streaming não encontrado"));

        MovieModel movieModel = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie não encontrado"));


        if (!movieModel.getStreaming().contains(streamingModel)) {
            throw new RuntimeException("Streaming não está adicionado");
        }
        else {
            movieModel.getStreaming().remove(streamingModel);
            return movieRepository.save(movieModel);
        }

    }
}

