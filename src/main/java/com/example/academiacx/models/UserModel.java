package com.example.academiacx.models;

import com.example.academiacx.models.dto.UserDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.List;

@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String username;

    private String email;

    private String password;


    @ManyToMany
    @JoinTable(
            name = "user_movies",
                joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<MovieModel> favoriteMovies;
    @ManyToMany
    @JoinTable(
            name = "user_directors",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<DirectorModel> favoriteDirectors;
        @Valid
        @OneToOne
        private AddressModel address;

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public List<MovieModel> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(List<MovieModel> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public List<DirectorModel> getFavoriteDirectors() {
        return favoriteDirectors;
    }

    public void setFavoriteDirectors(List<DirectorModel> favoriteDirectors) {
        this.favoriteDirectors = favoriteDirectors;
    }


    public UserModel() {
    }

    public UserModel(UserDto userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.username = userDto.getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
