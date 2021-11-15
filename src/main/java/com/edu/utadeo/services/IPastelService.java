package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Pastel;


public interface IPastelService {
	public List<Pastel> findAll();
	
	public Pastel save(Pastel p);
	
	public void delete(long id);
	
	public Pastel findById(long id);
}
