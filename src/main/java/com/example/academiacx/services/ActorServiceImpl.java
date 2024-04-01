package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.ActorModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.ActorDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.repository.ActorRepository;
import com.example.academiacx.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.academiacx.services.inter.ActorService;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<ActorDto> list() {
        List<ActorModel> listActors = actorRepository.findAll();
        return listActors.stream().map(x -> new ActorDto(x)).toList();
    }

    @Override
    public Optional<ActorDto> findById(Long id) {
        Optional<ActorModel> actorId =actorRepository.findById(id);
        return actorId.map(x -> new ActorDto(x));
    }

    @Override
    public ActorModel create(ActorModel actorModel) {
        actorModel.setId(null);

        return actorRepository.save(actorModel);
    }



    @Override
    public ActorModel update(ActorModel actorModel) {
        if(actorModel.getId() == null || findById(actorModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return actorRepository.save(actorModel);
    }
    public boolean delete(Long id) {

        ActorModel actor = actorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Actor não encontrado"));

        for (MovieModel movie : actor.getMovies()) {
            movie.getActors().remove(actor);
            movieRepository.save(movie);
        }

        actorRepository.delete(actor);


        return true;
    }

}
