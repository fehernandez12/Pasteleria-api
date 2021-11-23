package com.edu.utadeo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public ResponseEntity<?> save(@Valid @RequestBody Pastel d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Pastel p = new Pastel();
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (FieldError err: result.getFieldErrors()) {
				errors.add(err.getField());
			}
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.BAD_REQUEST);
		}
		try {
			p = d;
			d = pastelService.save(p);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pastel>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
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
