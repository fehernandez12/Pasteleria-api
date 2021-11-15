package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.utadeo.DAO.IEmpresaDAO;
import com.edu.utadeo.modelEntity.Empleado;
import com.edu.utadeo.modelEntity.Empresa;

public class EmpresaService implements IEmpresaService {
	@Autowired
	private IEmpresaDAO empresaDao;
	
	@Override
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return empresaDao.findAll();
	}

	@Override
	public Empresa save(Empresa e) {
		// TODO Auto-generated method stub
		return empresaDao.save(e);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		empresaDao.deleteById(id);
	}

	@Override
	public Empresa findById(long id) {
		// TODO Auto-generated method stub
		Optional<Empresa> empresa= empresaDao.findById(id);
		if (empresa.isPresent()) {
			return empresa.get();
		} else {
			return null;
		}
	}

}
