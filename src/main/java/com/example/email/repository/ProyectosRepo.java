package com.example.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.email.model.Proyectos;

@Repository
public interface ProyectosRepo extends JpaRepository<Proyectos ,Long>{

}
