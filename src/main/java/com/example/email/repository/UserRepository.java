package com.example.email.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.email.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByNombreAndPassword(String nombre,String password);

}
