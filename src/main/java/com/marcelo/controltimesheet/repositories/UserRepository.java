package com.marcelo.controltimesheet.repositories;

import com.marcelo.controltimesheet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
