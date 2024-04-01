package com.example.academiacx.services.inter;

import com.example.academiacx.models.FranchiseModel;
import com.example.academiacx.models.dto.FranchiseDto;

import java.util.List;
import java.util.Optional;

public interface FranchiseService {

    List<FranchiseDto> list();

    Optional<FranchiseDto> findById(Long id);

    FranchiseModel create(FranchiseModel franchiseModel);

    FranchiseModel update(FranchiseModel franchiseModel);
    boolean delete(Long id);
}
