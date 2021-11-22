package com.edu.utadeo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.edu.utadeo.modelEntity.Empleado;
import com.edu.utadeo.modelEntity.Persona;
import com.edu.utadeo.services.IEmpleadoService;
import com.edu.utadeo.services.IPersonaService;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins="*", allowedHeaders="*")
public class EmpleadoController {
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/")
	public List<Empleado> FindAll(){
		return empleadoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Empleado detail(@PathVariable UUID id) {
		return empleadoService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody Empleado d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Persona persona = new Persona();
		Persona p = personaService.save(persona);
		Empleado emp = new Empleado();
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
			emp = d;
			emp.setPersona(p);
			d = empleadoService.save(emp);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Empleado>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		empleadoService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Empleado update(@PathVariable UUID id, @RequestBody Empleado e) {
		Empleado actual = empleadoService.findById(id);
		actual.setNombres(e.getNombres());
		actual.setApellidos(e.getApellidos());
		actual.setSalarioActual(e.getSalarioActual());
		actual.setTipoEmpleado(e.getTipoEmpleado());
		return empleadoService.save(actual);
	}
}
