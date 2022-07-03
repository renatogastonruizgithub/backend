package com.example.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.email.model.Educacion;
@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long>{

}
