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
import com.edu.utadeo.services.IEmpleadoService;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins="*", allowedHeaders="*")
public class EmpleadoController {
	@Autowired
	private IEmpleadoService empleadoService;
	
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
	public Empleado save(@RequestBody Empleado e) {
		return empleadoService.save(e);
	}
	
	@DeleteMapping("/")
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
