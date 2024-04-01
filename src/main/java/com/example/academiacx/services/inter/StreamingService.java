package com.example.academiacx.services.inter;

import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.StreamingModel;
import com.example.academiacx.models.StudioModel;
import com.example.academiacx.models.dto.StreamingDto;

import java.util.List;
import java.util.Optional;

public interface StreamingService {

    List<StreamingDto> list();

    Optional<StreamingDto> findById(Long id);

    StreamingModel create(StreamingModel streamingModel);

    StreamingModel update(StreamingModel streamingModel);
    boolean delete(Long id);


}
