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
import com.edu.utadeo.modelEntity.Empresa;
import com.edu.utadeo.services.IEmpresaService;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins="*", allowedHeaders="*")
public class EmpresaController {
	@Autowired
	private IEmpresaService empresaService;
	
	@GetMapping("/")
	public List<Empresa> findAll(){
		return empresaService.findAll();
	}
	
	@GetMapping("/{id}")
	public Empresa detail(@PathVariable long id) {
		return empresaService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody Empresa d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Empresa empr = new Empresa();
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
			empr = d;
			d = empresaService.save(empr);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Empresa>(empr, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  delete(@PathVariable long id) {
		empresaService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Empresa update(@PathVariable long id, @RequestBody Empresa e) {
		Empresa actual = empresaService.findById(id);
		actual.setNombre(e.getNombre());
		actual.setNit(e.getNit());
		actual.setDireccion(e.getDireccion());
		return empresaService.save(actual);
	}
}
