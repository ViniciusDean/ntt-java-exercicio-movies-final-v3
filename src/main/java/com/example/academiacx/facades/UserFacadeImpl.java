package com.example.academiacx.facades;

import com.example.academiacx.facades.inter.UserFacade;
import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.AddressModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.AddressDto;
import com.example.academiacx.models.dto.UserBookmarkDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.repository.AddressRepository;
import com.example.academiacx.repository.UserRepository;
import com.example.academiacx.services.inter.AddressService;
import com.example.academiacx.services.inter.UserService;
import org.apache.catalina.User;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class UserFacadeImpl implements UserFacade {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    AddressRepository addressRepository;


    @Override
    public List<UserDto> listUsers() throws ObjectNotFoundException {
        ModelMapper modelMapper = new ModelMapper();

        final List<UserModel> users = userService.listUsers();
        final List<UserDto> userDtos = new ArrayList<>();

        if(CollectionUtils.isEmpty(users)) {
            throw new RuntimeException("Não há users cadastrados!");
        }
      //  populatorUsers(users, userDtos);
        for(UserModel user : users){
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userDtos.add(userDto);
        }

        return userDtos;
    }

    @Override
    public UserModel findById(Long id) {
        return null;
    }


    public List<UserBookmarkDto> getAllUserBookmarksDto() {
        return userService.getAllUserBookmarksDto();
    }

    @Override
    public UserModel create(UserModel userModel) {

        userModel.setId(null);

        UserModel existUser = userRepository.findByUsername(userModel.getUsername());

        if (existUser != null)
        {
            throw new ParametroInvalidoException("Usuario ja existe");
        }

        return userRepository.save(userModel);
    }

    @Override
    public UserModel update(UserModel userModel) {

        if(userModel.getId() == null ) {
            throw new ParametroInvalidoException("Id não encontrado");
      }

        return userRepository.save(userModel);
    }

    @Override
    public AddressDto saveAddress(AddressDto addressDto) {
        Long id = addressDto.getIduser();

        ModelMapper modelMapper = new ModelMapper();
        AddressDto addressDto1 = addressService.updateCep(addressDto);
        AddressModel addressModel = modelMapper.map(addressDto1, AddressModel.class);

       AddressModel address = addressRepository.save(addressModel);
       UserModel userModel = userService.findById(id).get();
        userModel.setAddress(addressModel);
        userRepository.save(userModel);


        return addressDto1;
    }



    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEntradoException("Id informado não encontrado!");
        }

    }

    @Override
    public void populatorUsers(final UserModel users, final UserDto userDto) {
       UserModel userModel;
            userDto.setId(users.getId());
            userDto.setName(users.getName());
            userDto.setEmail(users.getEmail());
            userDto.setUsername(users.getUsername());

    }
}
