package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.utadeo.DAO.ITipoPastelDAO;
import com.edu.utadeo.modelEntity.TipoEmpleado;
import com.edu.utadeo.modelEntity.TipoPastel;

public class TipoPastelService implements ITipoPastelService {
	@Autowired
	private ITipoPastelDAO tipoPastelDao;
	
	@Override
	public List<TipoPastel> findAll() {
		// TODO Auto-generated method stub
		return tipoPastelDao.findAll();
	}

	@Override
	public TipoPastel save(TipoPastel t) {
		// TODO Auto-generated method stub
		return tipoPastelDao.save(t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tipoPastelDao.deleteById(id);
	}

	@Override
	public TipoPastel findById(Long id) {
		// TODO Auto-generated method stub
		Optional<TipoPastel> tipoPastel= tipoPastelDao.findById(id);
		if (tipoPastel.isPresent()) {
			return tipoPastel.get();
		} else {
			return null;
		}
	}

}
