package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.TipoPastel;

public interface ITipoPastelService {
	public List<TipoPastel> findAll();
	
	public TipoPastel save(TipoPastel t);
	
	public void delete(Long id);
	
	public TipoPastel findById(Long id);
}
