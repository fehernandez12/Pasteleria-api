package com.edu.utadeo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.utadeo.modelEntity.Empleado;
import com.edu.utadeo.modelEntity.Ingrediente;
import com.edu.utadeo.services.IEmpleadoService;
import com.edu.utadeo.services.IIngredienteService;

@RestController
@RequestMapping("/api/ingredientes")
@CrossOrigin(origins="*", allowedHeaders="*")
public class IngredienteController {
	@Autowired
	private IIngredienteService ingredienteService;
	
	@GetMapping("/")
	public List<Ingrediente> FindAll(){
		return ingredienteService.findAll();
	}
	
	@GetMapping("/{id}")
	public Ingrediente detail(@PathVariable long id) {
		return ingredienteService.findById(id);
	}
}
