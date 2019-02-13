package com.marcelo.controltimesheet.services;

import com.marcelo.controltimesheet.entities.User;
import com.marcelo.controltimesheet.repositories.UserRepository;
import com.marcelo.controltimesheet.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User find(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "O objeto não encontrado! Id: " + id + ", Tipo:" + User.class.getName()));
    }


    public User insert(User obj) {
        obj.setId(null);
        return userRepository.save(obj);
    }

    public List<User> findAll() {

       return userRepository.findAll();
    }
}
