package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.utadeo.DAO.IPastelDAO;
import com.edu.utadeo.modelEntity.Ingrediente;
import com.edu.utadeo.modelEntity.Pastel;

public class PastelService implements IPastelService {
	@Autowired
	private IPastelDAO pastelDao;
	
	@Override
	public List<Pastel> findAll() {
		// TODO Auto-generated method stub
		return pastelDao.findAll();
	}

	@Override
	public Pastel save(Pastel p) {
		// TODO Auto-generated method stub
		return pastelDao.save(p);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		pastelDao.deleteById(id);
	}

	@Override
	public Pastel findById(long id) {
		// TODO Auto-generated method stub
		Optional<Pastel> pastel= pastelDao.findById(id);
		if (pastel.isPresent()) {
			return pastel.get();
		} else {
			return null;
		}
	}

}
