package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.DAO.IPedidoDAO;
import com.edu.utadeo.modelEntity.Pastel;
import com.edu.utadeo.modelEntity.Pedido;

@Service
public class PedidoService implements IPedidoService {
	@Autowired
	private IPedidoDAO pedidoDao;
	
	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return pedidoDao.findAll();
	}

	@Override
	public Pedido save(Pedido p) {
		// TODO Auto-generated method stub
		return pedidoDao.save(p);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		pedidoDao.deleteById(id);
	}

	@Override
	public Pedido findById(long id) {
		// TODO Auto-generated method stub
		Optional<Pedido> pedido= pedidoDao.findById(id);
		if (pedido.isPresent()) {
			return pedido.get();
		} else {
			return null;
		}
	}

}
