package com.formulario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formulario.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
