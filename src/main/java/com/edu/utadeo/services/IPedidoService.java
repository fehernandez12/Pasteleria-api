package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Pedido;

public interface IPedidoService {
	public List<Pedido> findAll();
	
	public Pedido save(Pedido p);
	
	public void delete(long id);
	
	public Pedido findById(long id);
}
