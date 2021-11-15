package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.DAO.IEtapaPastelDAO;
import com.edu.utadeo.modelEntity.Empresa;
import com.edu.utadeo.modelEntity.EtapaPastel;

@Service
public class EtapaPastelService implements IEtapaPastelService {
	@Autowired
	private IEtapaPastelDAO etapaPastelDao;
	
	@Override
	public List<EtapaPastel> findAll() {
		// TODO Auto-generated method stub
		return etapaPastelDao.findAll();
	}

	@Override
	public EtapaPastel save(EtapaPastel e) {
		// TODO Auto-generated method stub
		return etapaPastelDao.save(e);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		etapaPastelDao.deleteById(id);
	}

	@Override
	public EtapaPastel findById(long id) {
		// TODO Auto-generated method stub
		Optional<EtapaPastel> etapaPastel= etapaPastelDao.findById(id);
		if (etapaPastel.isPresent()) {
			return etapaPastel.get();
		} else {
			return null;
		}
	}

}
