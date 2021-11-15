package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.DAO.IPersonaExternaDAO;
import com.edu.utadeo.modelEntity.PersonaExterna;

@Service
public class PersonaExternaService implements IPersonaExternaService {
	@Autowired
	private IPersonaExternaDAO personaExternaDao;
	
	@Override
	public List<PersonaExterna> findAll() {
		// TODO Auto-generated method stub
		return personaExternaDao.findAll();
	}

	@Override
	public PersonaExterna save(PersonaExterna p) {
		// TODO Auto-generated method stub
		return personaExternaDao.save(p);
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		personaExternaDao.deleteById(id);
	}

	@Override
	public PersonaExterna findById(UUID id) {
		// TODO Auto-generated method stub
		Optional<PersonaExterna> personaExterna= personaExternaDao.findById(id);
		if (personaExterna.isPresent()) {
			return personaExterna.get();
		} else {
			return null;
		}
	}

}
