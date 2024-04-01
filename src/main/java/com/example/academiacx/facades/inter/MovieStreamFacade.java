package com.example.academiacx.facades.inter;

import com.example.academiacx.models.MovieModel;

public interface MovieStreamFacade {
    MovieModel setMovieStream(Long streamingId, Long movieId);
    MovieModel  removeFromStreaming(Long streamingId, Long movieId);

}
