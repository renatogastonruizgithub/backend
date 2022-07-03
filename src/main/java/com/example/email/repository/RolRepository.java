package com.example.email.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.email.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	public Optional<Rol> findByNombre(String nombre);
}
