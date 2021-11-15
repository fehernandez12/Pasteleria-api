package com.edu.utadeo.services;

import java.util.List;
import java.util.UUID;

import com.edu.utadeo.modelEntity.Empleado;

public interface IEmpleadoService {
	public List<Empleado> findAll();
	
	public Empleado save(Empleado e);
	
	public void delete(UUID id);
	
	public Empleado findById(UUID id);
}
