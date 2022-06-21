package com.example.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.email.model.Habilidades;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades,Long>{

}
