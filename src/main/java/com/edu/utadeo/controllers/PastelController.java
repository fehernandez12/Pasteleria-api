package com.edu.utadeo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.utadeo.modelEntity.Empleado;
import com.edu.utadeo.modelEntity.Pastel;
import com.edu.utadeo.services.IEmpleadoService;
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
}