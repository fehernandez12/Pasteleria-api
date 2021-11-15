package com.edu.utadeo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edu.utadeo.modelEntity.Empleado;
import com.edu.utadeo.modelEntity.Persona;
import com.edu.utadeo.services.IEmpleadoService;
import com.edu.utadeo.services.IPersonaService;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PersonaController {
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/")
	public List<Persona> FindAll(){
		return personaService.findAll();
	}
	
	@GetMapping("/{id}")
	public Persona detail(@PathVariable long id) {
		return personaService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona save(@RequestBody Persona e) {
		return personaService.save(e);
	}
	
	@DeleteMapping("/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		personaService.delete(id);
	}
}
