package com.example.academiacx.facades;

import com.example.academiacx.facades.inter.MovieFranchiseFacade;
import com.example.academiacx.models.FranchiseModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.repository.FranchiseRepository;
import com.example.academiacx.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieFranchiseFacadeImpl implements MovieFranchiseFacade {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    FranchiseRepository franchiseRepository;
    @Override
    public MovieModel setFranchise(Long movieId, Long franchiseId) {
        MovieModel movieModel = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));

        FranchiseModel franchiseModel = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new IllegalArgumentException("Franchise not found"));
        if (movieModel.getFranchise() != null) {
            throw new IllegalArgumentException("Movie já está em uma franchise");
        }
        else {
            movieModel.setFranchise(franchiseModel);
            return movieRepository.save(movieModel);
        }

    }
}
