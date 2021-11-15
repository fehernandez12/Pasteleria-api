package com.edu.utadeo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Pastel;

public interface IPastelDAO extends JpaRepository<Pastel, Long> {

}
