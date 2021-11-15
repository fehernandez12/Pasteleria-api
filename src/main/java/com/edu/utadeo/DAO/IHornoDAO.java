package com.edu.utadeo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Horno;

public interface IHornoDAO extends JpaRepository<Horno, Long> {

}
