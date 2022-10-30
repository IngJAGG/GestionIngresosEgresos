package com.jagg.pruebaproyecto.service;

import com.jagg.pruebaproyecto.entities.User;
import com.jagg.pruebaproyecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User crearUsuario(User nuevoUsario){
        return this.userRepository.save(nuevoUsario);
    }

    public User getOrCreateUser(Map<String, Object> userData){
        String email = (String) userData.get("email");
        String image = (String) userData.get("picture");
        String auth0Id = (String) userData.get("sub");

        User nuevoUsuario = new User(email=email, image=image, auth0Id=auth0Id);
        return crearUsuario(nuevoUsuario);
    }
}
