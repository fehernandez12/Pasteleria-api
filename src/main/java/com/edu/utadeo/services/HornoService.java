package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.DAO.IHornoDAO;
import com.edu.utadeo.modelEntity.EtapaPastel;
import com.edu.utadeo.modelEntity.Horno;

@Service
public class HornoService implements IHornoService {
	@Autowired
	private IHornoDAO hornoDao;
	
	@Override
	public List<Horno> findAll() {
		// TODO Auto-generated method stub
		return hornoDao.findAll();
	}

	@Override
	public Horno save(Horno h) {
		// TODO Auto-generated method stub
		return hornoDao.save(h);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		hornoDao.deleteById(id);
	}

	@Override
	public Horno findById(long id) {
		// TODO Auto-generated method stub
		Optional<Horno> horno= hornoDao.findById(id);
		if (horno.isPresent()) {
			return horno.get();
		} else {
			return null;
		}
	}

}
