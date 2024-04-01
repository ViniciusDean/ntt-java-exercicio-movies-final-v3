package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.*;
import com.example.academiacx.models.dto.StreamingDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.repository.MovieRepository;
import com.example.academiacx.repository.StreamingRepository;
import com.example.academiacx.services.inter.MovieService;
import com.example.academiacx.services.inter.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingServiceImpl implements StreamingService {
    @Autowired
    private StreamingRepository streamingRepository;
    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<StreamingDto> list() {
        List<StreamingModel> listStream = streamingRepository.findAll();
        return listStream.stream().map(x -> new StreamingDto(x)).toList();
    }

    @Override
    public Optional<StreamingDto> findById(Long id)
    {
        Optional<StreamingModel> streamId = streamingRepository.findById(id);
        return streamId.map(x -> new StreamingDto(x));
    }

    @Override
    public StreamingModel create(StreamingModel streamingModel) {
        streamingModel.setId(null);

        return streamingRepository.save(streamingModel);
    }

    @Override
    public StreamingModel update(StreamingModel streamingModel) {
        if(streamingModel.getId() == null || findById(streamingModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return streamingRepository.save(streamingModel);
    }
    public boolean delete(Long id) {

        StreamingModel streaming = streamingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Streaming não encontrado"));

        for (MovieModel movie : streaming.getMovies()) {
            movie.getStreaming().remove(streaming);
            movieRepository.save(movie);
        }

        streamingRepository.delete(streaming);
        return true;
    }






}
