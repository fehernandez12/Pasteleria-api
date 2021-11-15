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
import com.edu.utadeo.modelEntity.PersonaExterna;
import com.edu.utadeo.services.IPersonaExternaService;

@RestController
@RequestMapping("/api/persona_externa")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PersonaExternaController {

	@Autowired
	private IPersonaExternaService personaExternaService;
	
	@GetMapping("/")
	public List<PersonaExterna> FindAll(){
		return personaExternaService.findAll();
	}
	
	@GetMapping("/{id}")
	public PersonaExterna detail(@PathVariable UUID id) {
		return personaExternaService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonaExterna save(@RequestBody PersonaExterna e) {
		return personaExternaService.save(e);
	}
	
	@DeleteMapping("/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		personaExternaService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public PersonaExterna update(@PathVariable UUID id, @RequestBody PersonaExterna e) {
		PersonaExterna actual = personaExternaService.findById(id);
		actual.setId(e.getId());
		actual.setCedula(e.getCedula());
		actual.setNombres(e.getNombres());
		actual.setApellidos(e.getApellidos());
		actual.setDir(e.getDir());
		actual.setFechaNac(e.getFechaNac());
		return personaExternaService.save(actual);
	}
}