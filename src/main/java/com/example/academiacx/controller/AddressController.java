package com.example.academiacx.controller;

import com.example.academiacx.facades.inter.UserFacade;
import com.example.academiacx.models.AddressModel;
import com.example.academiacx.models.dto.ActorDto;
import com.example.academiacx.models.dto.AddressDto;
import com.example.academiacx.services.inter.AddressService;
import com.example.academiacx.utils.MovieUtil;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    UserFacade userFacade;
    @GetMapping(value = "/list")
    public ResponseEntity<?> findAll()
    {
        List<AddressModel> response = addressService.list();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
    @PostMapping(value = "/save")
    public ResponseEntity<?> update(@RequestBody AddressDto addressDto)
    {
        userFacade.saveAddress(addressDto);

        return new ResponseEntity<>(MovieUtil.result("Usuario salvo com sucesso!!", HttpStatus.OK.value()), HttpStatus.OK);



    }
}
