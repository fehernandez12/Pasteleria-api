package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.TipoEmpleado;

public interface ITipoEmpleadoService {
	public List<TipoEmpleado> findAll();
	
	public TipoEmpleado save(TipoEmpleado p);
	
	public void delete(Long id);
	
	public TipoEmpleado findById(Long id);
}
