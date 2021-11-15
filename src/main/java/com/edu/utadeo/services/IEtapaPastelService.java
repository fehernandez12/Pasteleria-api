package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.EtapaPastel;



public interface IEtapaPastelService {
	public List<EtapaPastel> findAll();
	
	public EtapaPastel save(EtapaPastel e);
	
	public void delete(long id);
	
	public EtapaPastel findById(long id);
}
