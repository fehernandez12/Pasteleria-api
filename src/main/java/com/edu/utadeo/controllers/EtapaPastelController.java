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
import com.edu.utadeo.modelEntity.EtapaPastel;
import com.edu.utadeo.services.IEtapaPastelService;

@RestController
@RequestMapping("/api/etapa_pastel")
@CrossOrigin(origins="*", allowedHeaders="*")
public class EtapaPastelController {
	@Autowired
	private IEtapaPastelService etapaPastelService;
	
	@GetMapping("/")
	public List<EtapaPastel> findAll(){
		return etapaPastelService.findAll();
	}
	
	@GetMapping("/{id}")
	public EtapaPastel detail(@PathVariable long id) {
		return etapaPastelService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody EtapaPastel d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		EtapaPastel et = new EtapaPastel();
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
			et = d;
			d = etapaPastelService.save(et);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EtapaPastel>(et, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		etapaPastelService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public EtapaPastel update(@PathVariable long id, @RequestBody EtapaPastel l) {
		EtapaPastel actual = etapaPastelService.findById(id);
		actual.setFechaFin(l.getFechaFin());
		actual.setFechaInicio(l.getFechaInicio());
		actual.setTempCoccion(l.getTempCoccion());
		actual.setHornoAsignado(l.getHornoAsignado());
		return etapaPastelService.save(actual);
	}
}
