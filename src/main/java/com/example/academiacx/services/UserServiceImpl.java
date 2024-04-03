package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.StudioModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.UserBookmarkDto;
import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.repository.UserRepository;
import com.example.academiacx.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> listUsers() {
        List<UserModel> listUsers = userRepository.findAll();
        return listUsers;
    }
    @Override
    public Optional<UserModel> findById(Long id)
    {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel;
    }
    public List<UserBookmarkDto> getAllUserBookmarksDto() {
        List<UserModel> listUsers = userRepository.findAll();
        return listUsers.stream().map(x -> new UserBookmarkDto(x)).toList();
    }



    @Override
    public UserModel create(UserModel userModel) {

        userModel.setId(null);

        UserModel existUser = userRepository.findByUsername(userModel.getUsername());

        if (existUser != null)
        {
            throw new ParametroInvalidoException("Usuario ja existe");
        }

//        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));

        return userRepository.save(userModel);
    }

    @Override
    public UserModel update(UserModel userModel) {

        if(userModel.getId() == null || findById(userModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return userRepository.save(userModel);
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
}