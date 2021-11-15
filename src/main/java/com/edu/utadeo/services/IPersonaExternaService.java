package com.edu.utadeo.services;

import java.util.List;
import java.util.UUID;

import com.edu.utadeo.modelEntity.PersonaExterna;


public interface IPersonaExternaService {
	public List<PersonaExterna> findAll();
	
	public PersonaExterna save(PersonaExterna p);
	
	public void delete(UUID id);
	
	public PersonaExterna findById(UUID id);
}
