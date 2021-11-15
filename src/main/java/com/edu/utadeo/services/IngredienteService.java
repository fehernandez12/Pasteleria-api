package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.DAO.IIngredienteDAO;
import com.edu.utadeo.modelEntity.Horno;
import com.edu.utadeo.modelEntity.Ingrediente;

@Service
public class IngredienteService implements IIngredienteService {
	@Autowired
	private IIngredienteDAO ingredienteDao;
	
	@Override
	public List<Ingrediente> findAll() {
		// TODO Auto-generated method stub
		return ingredienteDao.findAll();
	}

	@Override
	public Ingrediente save(Ingrediente i) {
		// TODO Auto-generated method stub
		return ingredienteDao.save(i);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		ingredienteDao.deleteById(id);
	}

	@Override
	public Ingrediente findById(long id) {
		// TODO Auto-generated method stub
		Optional<Ingrediente> ingrediente= ingredienteDao.findById(id);
		if (ingrediente.isPresent()) {
			return ingrediente.get();
		} else {
			return null;
		}
	}

}
