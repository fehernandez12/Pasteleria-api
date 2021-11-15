package com.edu.utadeo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Persona;

public interface IPersonaDAO extends JpaRepository<Persona, Long> {

}
