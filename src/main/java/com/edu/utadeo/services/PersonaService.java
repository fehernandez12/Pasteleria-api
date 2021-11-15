package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.DAO.IPersonaDAO;
import com.edu.utadeo.modelEntity.Persona;

@Service
public class PersonaService implements IPersonaService {
	@Autowired
	private IPersonaDAO personaDao;
	
	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaDao.findAll();
	}

	@Override
	public Persona save(Persona p) {
		// TODO Auto-generated method stub
		return personaDao.save(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		personaDao.deleteById(id);
	}

	@Override
	public Persona findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Persona> persona= personaDao.findById(id);
		if (persona.isPresent()) {
			return persona.get();
		} else {
			return null;
		}
	}

}
