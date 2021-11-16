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
import com.edu.utadeo.modelEntity.TipoPastel;
import com.edu.utadeo.services.ITipoPastelService;

@RestController
@RequestMapping("/api/tipo_pastel")
@CrossOrigin(origins="*", allowedHeaders="*")
public class TipoPastelController {
	@Autowired
	private  ITipoPastelService tipoPastelService;
	
	@GetMapping("/")
	public List<TipoPastel> FindAll(){
		return tipoPastelService.findAll();
	}
	
	@GetMapping("/{id}")
	public TipoPastel detail(@PathVariable Long id) {
		return tipoPastelService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody TipoPastel d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		TipoPastel tp = new TipoPastel();
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
			tp = d;
			d = tipoPastelService.save(tp);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TipoPastel>(tp, HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tipoPastelService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public TipoPastel update(@PathVariable Long id, @RequestBody TipoPastel e) {
		TipoPastel actual = tipoPastelService.findById(id);
		actual.setId(e.getId());
		actual.setDescripcion(e.getDescripcion());
		return tipoPastelService.save(actual);
	}

}