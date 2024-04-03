package com.example.academiacx.repository;

import com.example.academiacx.models.ActorModel;
import com.example.academiacx.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {
}
