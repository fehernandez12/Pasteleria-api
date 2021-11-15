package com.edu.utadeo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Empresa;

public interface IEmpresaDAO extends JpaRepository<Empresa, Long> {

}
