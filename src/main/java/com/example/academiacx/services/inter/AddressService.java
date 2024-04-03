package com.example.academiacx.services.inter;

import com.example.academiacx.models.AddressModel;
import com.example.academiacx.models.dto.ActorDto;
import com.example.academiacx.models.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto updateCep (AddressDto addressDto);
    List<AddressModel> list();
  //AddressDto getCep (String cep);
}
