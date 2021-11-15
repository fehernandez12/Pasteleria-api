package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.utadeo.DAO.ITipoEmpleadoDAO;
import com.edu.utadeo.modelEntity.PersonaExterna;
import com.edu.utadeo.modelEntity.TipoEmpleado;

public class TipoEmpleadoService implements ITipoEmpleadoService {
	@Autowired
	private ITipoEmpleadoDAO tipoEmpleadoDao;
	
	@Override
	public List<TipoEmpleado> findAll() {
		// TODO Auto-generated method stub
		return tipoEmpleadoDao.findAll();
	}

	@Override
	public TipoEmpleado save(TipoEmpleado p) {
		// TODO Auto-generated method stub
		return tipoEmpleadoDao.save(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tipoEmpleadoDao.deleteById(id);
	}

	@Override
	public TipoEmpleado findById(Long id) {
		// TODO Auto-generated method stub
		Optional<TipoEmpleado> tipoEmpleado= tipoEmpleadoDao.findById(id);
		if (tipoEmpleado.isPresent()) {
			return tipoEmpleado.get();
		} else {
			return null;
		}
	}

}
