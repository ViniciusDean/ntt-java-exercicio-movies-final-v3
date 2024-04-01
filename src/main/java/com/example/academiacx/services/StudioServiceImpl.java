package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.*;
import com.example.academiacx.models.dto.StudioDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.repository.FranchiseRepository;
import com.example.academiacx.repository.MovieRepository;
import com.example.academiacx.repository.StudioRepository;
import com.example.academiacx.repository.custom.StudioCustomRepository;
import com.example.academiacx.services.inter.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    public List<StudioDto> list() {
        List<StudioModel> studio = studioRepository.findAll();
        return studio.stream().map(x -> new StudioDto(x)).toList();
    }

    @Override
    public Optional<StudioDto> findById(Long id) {

        Optional<StudioModel> studioId = studioRepository.findById(id);
        return studioId.map(x -> new StudioDto(x));
    }

    @Override
    public Optional<StudioModel> findByName(String name) {

        return Optional.ofNullable(studioRepository.findByName(name));
    }

    @Override
    public StudioModel create(StudioModel studioModel) {
        studioModel.setId(null);

        return studioRepository.save(studioModel);
    }

    @Override
    public StudioModel update(StudioModel studioModel) {
        if(studioModel.getId() == null || findById(studioModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return studioRepository.save(studioModel);
    }

    @Override
    public boolean delete(Long id) {
        StudioModel studio = studioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Genre não encontrado"));

        for (MovieModel movie : studio.getMovies()) {
            movie.setStudio(null);
            movieRepository.save(movie);
        }
        for (FranchiseModel franchise : studio.getFranchise()) {
            franchise.setStudio(null);
            franchiseRepository.save(franchise);
        }


        studioRepository.delete(studio);
        return true;
    }
}