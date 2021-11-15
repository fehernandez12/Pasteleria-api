package com.edu.utadeo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Ingrediente;

public interface IIngredienteDAO extends JpaRepository<Ingrediente, Long> {

}
