package com.example.academiacx.services.inter;

import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.dto.DirectorDto;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    List<DirectorDto> list();

    Optional<DirectorModel> findById(Long id);

    DirectorModel create(DirectorModel directorModel);

    DirectorModel update(DirectorModel directorModel);
    boolean delete(Long id);

}
