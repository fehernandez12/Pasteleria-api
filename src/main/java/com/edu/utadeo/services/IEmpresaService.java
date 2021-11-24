package com.edu.utadeo.services;

import java.util.List;
import java.util.UUID;

import com.edu.utadeo.modelEntity.Empresa;

public interface IEmpresaService {
	public List<Empresa> findAll();
	
	public Empresa save(Empresa e);
	
	public void delete(UUID id);
	
	public Empresa findById(UUID id);
}
