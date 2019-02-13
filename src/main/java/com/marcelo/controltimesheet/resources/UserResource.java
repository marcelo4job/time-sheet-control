package com.marcelo.controltimesheet.resources;

import com.marcelo.controltimesheet.entities.User;
import com.marcelo.controltimesheet.repositories.UserRepository;
import com.marcelo.controltimesheet.services.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "users")
public class UserResource {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        User obj = userService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody User obj) {
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){

        List<User> list = userService.findAll();

        return userRepository.findAll();
    }
}


