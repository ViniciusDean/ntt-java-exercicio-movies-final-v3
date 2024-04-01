package com.example.academiacx.services.inter;

import com.example.academiacx.models.ActorModel;
import com.example.academiacx.models.dto.ActorDto;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<ActorDto> list();

    Optional<ActorDto> findById(Long id);

    ActorModel create(ActorModel actorModel);

    ActorModel update(ActorModel actorModel);
    boolean delete(Long id);

}
