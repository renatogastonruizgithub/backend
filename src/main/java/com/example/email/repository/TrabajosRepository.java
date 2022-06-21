package com.example.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.email.model.Trabajos;
@Repository
public interface TrabajosRepository extends JpaRepository<Trabajos,Long> {
	
}
