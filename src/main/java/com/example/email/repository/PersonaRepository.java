package com.example.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.email.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
