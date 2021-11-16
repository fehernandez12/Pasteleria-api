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
import com.edu.utadeo.modelEntity.Horno;
import com.edu.utadeo.services.IHornoService;


@RestController
@RequestMapping("/api/hornos")
@CrossOrigin(origins="*", allowedHeaders="*")
public class HornoController {
	@Autowired
	private IHornoService hornoService;
	
	@GetMapping("/")
	public List<Horno> findAll(){
		return hornoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Horno detail(@PathVariable long id) {
		return hornoService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody Horno d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Horno hr = new Horno();
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
			hr = d;
			d = hornoService.save(hr);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Horno>(hr, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		hornoService.delete(id); 
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Horno update(@PathVariable long id, @RequestBody Horno h) {
		Horno actual = hornoService.findById(id);
		actual.setMarca(h.getMarca());
		actual.setvEstimadoActual(h.getvEstimadoActual());
		return hornoService.save(actual);
	}
}
