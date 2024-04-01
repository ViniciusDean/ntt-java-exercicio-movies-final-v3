package com.example.academiacx.facades.inter;

import com.example.academiacx.models.MovieModel;

public interface MovieFranchiseFacade {
    MovieModel setFranchise(Long movieId, Long franchiseId);

}
