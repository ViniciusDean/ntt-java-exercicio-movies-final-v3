package com.example.academiacx.services;

import com.example.academiacx.models.ActorModel;
import com.example.academiacx.models.AddressModel;
import com.example.academiacx.models.dto.ActorDto;
import com.example.academiacx.models.dto.AddressDto;
import com.example.academiacx.repository.ActorRepository;
import com.example.academiacx.repository.AddressRepository;
import com.example.academiacx.services.inter.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public AddressDto updateCep (AddressDto addressDto){
        String url = "https://viacep.com.br/ws/"+addressDto.getCep()+"/json/";
        RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<AddressDto> addressDto1 = restTemplate.getForEntity(url, AddressDto.class);
        return addressDto1.getBody();
    }
    @Override
    public List<AddressModel> list() {
        return addressRepository.findAll();
    }
  /*
  public AddressDto getCep (String cep){
      String url = "https://viacep.com.br/ws/"+cep+"/json/";
      RestTemplate restTemplate = new RestTemplate();

      final ResponseEntity<AddressDto> addressDto1 = restTemplate.getForEntity(url, AddressDto.class);
      return addressDto1.getBody();
  }

   */
}
