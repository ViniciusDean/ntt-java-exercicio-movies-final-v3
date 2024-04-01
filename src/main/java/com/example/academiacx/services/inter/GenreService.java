package com.example.academiacx.services.inter;

import com.example.academiacx.models.GenreModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.GenreDto;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreDto> list();
    Optional<GenreDto> findById(Long id);

    GenreModel create(GenreModel genreModel);

    GenreModel update(GenreModel genreModel);
    boolean delete(Long id);


}
