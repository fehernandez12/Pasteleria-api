package com.edu.utadeo.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, UUID> {

}
