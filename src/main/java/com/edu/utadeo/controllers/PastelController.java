package com.edu.utadeo.controllers;

import java.util.List;

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

import com.edu.utadeo.modelEntity.Pastel;
import com.edu.utadeo.services.IPastelService;

@RestController
@RequestMapping("/api/pasteles")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PastelController {
	@Autowired
	private IPastelService pastelService;
	
	@GetMapping("/")
	public List<Pastel> FindAll(){
		return pastelService.findAll();
	}
	
	@GetMapping("/{id}")
	public Pastel detail(@PathVariable long id) {
		return pastelService.findById(id);
	}
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Pastel save(@RequestBody Pastel e) {
		return pastelService.save(e);
	}
	
	@DeleteMapping("/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		pastelService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pastel update(@PathVariable long id, @RequestBody Pastel e) {
		Pastel actual = pastelService.findById(id);
		actual.setNombre(e.getNombre());
		actual.setTipo(e.getTipo());
		actual.setPesoMin(e.getPesoMin());
		actual.setAdicional(e.getAdicional());
		return pastelService.save(actual);
	}
}
