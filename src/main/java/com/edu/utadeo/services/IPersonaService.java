package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Persona;

public interface IPersonaService {
	public List<Persona> findAll();
	
	public Persona save(Persona p);
	
	public void delete(Long id);
	
	public Persona findById(Long id);
}
