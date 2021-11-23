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
import com.edu.utadeo.modelEntity.Ingrediente;
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
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody Ingrediente d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Ingrediente in = new Ingrediente();
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
			in = d;
			d = ingredienteService.save(in);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ingrediente>(in, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		ingredienteService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Ingrediente update(@PathVariable long id, @RequestBody Ingrediente e) {
		Ingrediente actual = ingredienteService.findById(id);
		actual.setNombre(e.getNombre());
		actual.setuMed(e.getuMed());
		return ingredienteService.save(actual);
	}
}
