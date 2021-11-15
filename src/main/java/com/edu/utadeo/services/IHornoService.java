package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Horno;

public interface IHornoService {
	public List<Horno> findAll();
	
	public Horno save(Horno h);
	
	public void delete(long id);
	
	public Horno findById(long id);	
}
