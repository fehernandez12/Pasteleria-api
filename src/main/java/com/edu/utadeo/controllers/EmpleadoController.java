package com.edu.utadeo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	//@GetMapping("/{id}")
	//public Emplea
}
