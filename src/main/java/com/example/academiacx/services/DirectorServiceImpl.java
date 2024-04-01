package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.DirectorDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.repository.ActorRepository;
import com.example.academiacx.repository.DirectorRepository;
import com.example.academiacx.repository.UserRepository;
import com.example.academiacx.services.inter.ActorService;
import com.example.academiacx.services.inter.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<DirectorDto> list() {
        List<DirectorModel> list = directorRepository.findAll();
        return list.stream().map(x -> new DirectorDto(x)).toList();
    }

    @Override
    public Optional<DirectorModel> findById(Long id) {
        return directorRepository.findById(id);
    }

    @Override
    public DirectorModel create(DirectorModel actorModel) {
        actorModel.setId(null);

        return directorRepository.save(actorModel);
    }
    
    @Override
    public DirectorModel update(DirectorModel actorModel) {
        if(actorModel.getId() == null || findById(actorModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return directorRepository.save(actorModel);
    }
    public boolean delete(Long id) {

        DirectorModel director = directorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Director not found"));

        for (UserModel user : director.getUser()) {
            user.getFavoriteDirectors().remove(director);
            userRepository.save(user);
        }

        directorRepository.delete(director);
        return true;
    }

}
