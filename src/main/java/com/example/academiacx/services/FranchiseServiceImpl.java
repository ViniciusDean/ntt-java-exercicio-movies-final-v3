package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.ActorModel;
import com.example.academiacx.models.FranchiseModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.FranchiseDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.repository.FranchiseRepository;
import com.example.academiacx.repository.MovieRepository;
import com.example.academiacx.services.inter.FranchiseService;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<FranchiseDto> list()
    {
        List<FranchiseModel> listFranchise = franchiseRepository.findAll();
        return listFranchise.stream().map(x -> new FranchiseDto(x)).toList();
    }

    @Override
    public Optional<FranchiseDto> findById(Long id)
    {
        Optional<FranchiseModel> FranchiseId = franchiseRepository.findById(id);
        return FranchiseId.map(x -> new FranchiseDto(x));
    }

    @Override
    public FranchiseModel create(FranchiseModel franchiseModel) {
        franchiseModel.setId(null);

        return franchiseRepository.save(franchiseModel);
    }

    @Override
    public FranchiseModel update(FranchiseModel franchiseModel) {
        if(franchiseModel.getId() == null || findById(franchiseModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return franchiseRepository.save(franchiseModel);
    }
    public boolean delete(Long id) {

        FranchiseModel franchise = franchiseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Franchise não encontrado"));

        for (MovieModel movie : franchise.getMovies()) {
            movie.setFranchise(null);
            movieRepository.save(movie);
        }

        franchiseRepository.delete(franchise);
        return true;
    }
}
