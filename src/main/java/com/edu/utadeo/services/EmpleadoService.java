package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.DAO.IEmpleadoDAO;
import com.edu.utadeo.modelEntity.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService {
	@Autowired
	private IEmpleadoDAO empleadoDao;
	
	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return empleadoDao.findAll();
	}

	@Override
	public Empleado save(Empleado e) {
		// TODO Auto-generated method stub
		return empleadoDao.save(e);
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		empleadoDao.deleteById(id);
	}

	@Override
	public Empleado findById(UUID id) {
		// TODO Auto-generated method stub
		Optional<Empleado> empleado= empleadoDao.findById(id);
		if (empleado.isPresent()) {
			return empleado.get();
		} else {
			return null;
		}
	}

}
