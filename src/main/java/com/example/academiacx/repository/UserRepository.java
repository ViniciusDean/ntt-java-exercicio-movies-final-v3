package com.example.academiacx.repository;

import com.example.academiacx.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail (String email);



    @Query("from UserModel u where u.username = :username") //JPQL
    UserModel busquePorNome (String username);

    @Query("from UserModel u where u.email = :email") //JPQL
    UserModel busquePorEmail (@Param("email") String email);


    UserModel findByUsername(String username);

}
