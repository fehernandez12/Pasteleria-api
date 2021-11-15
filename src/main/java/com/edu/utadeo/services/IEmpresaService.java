package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Empresa;

public interface IEmpresaService {
	public List<Empresa> findAll();
	
	public Empresa save(Empresa e);
	
	public void delete(long id);
	
	public Empresa findById(long id);
}
