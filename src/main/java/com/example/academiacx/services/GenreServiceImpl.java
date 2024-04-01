package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.FranchiseModel;
import com.example.academiacx.models.GenreModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.GenreDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.repository.FranchiseRepository;
import com.example.academiacx.repository.GenreRepository;
import com.example.academiacx.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.academiacx.services.inter.GenreService;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    public List<GenreDto> list() {
        List<GenreModel> listGenres = genreRepository.findAll();
        return listGenres.stream().map(x -> new GenreDto(x)).toList();
    }

    @Override
    public Optional<GenreDto> findById(Long id) {
        Optional<GenreModel> genreId = genreRepository.findById(id);
        return genreId.map(x -> new GenreDto(x));
    }

    @Override
    public GenreModel create(GenreModel genreModel) {
        genreModel.setId(null);

        return genreRepository.save(genreModel);
    }

    @Override
    public GenreModel update(GenreModel genreModel) {
        if(genreModel.getId() == null || findById(genreModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return genreRepository.save(genreModel);
    }
    public boolean delete(Long id) {

        GenreModel genre = genreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Genre não encontrado"));

        for (MovieModel movie : genre.getMovies()) {
            movie.setGenre(null);
            movieRepository.save(movie);
        }
        for (FranchiseModel franchise : genre.getFranchise()) {
            franchise.setGenre(null);
            franchiseRepository.save(franchise);
        }

        genreRepository.delete(genre);
        return true;

    }


}
