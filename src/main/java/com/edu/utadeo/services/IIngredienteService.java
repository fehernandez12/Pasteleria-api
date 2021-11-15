package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Ingrediente;


public interface IIngredienteService {
	public List<Ingrediente> findAll();
	
	public Ingrediente save(Ingrediente i);
	
	public void delete(long id);
	
	public Ingrediente findById(long id);	
}
