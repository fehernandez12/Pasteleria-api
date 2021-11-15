package com.edu.utadeo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.TipoEmpleado;

public interface ITipoEmpleadoDAO extends JpaRepository<TipoEmpleado, Long> {

}
