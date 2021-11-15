package com.edu.utadeo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.utadeo.modelEntity.Empresa;
import com.edu.utadeo.services.IEmpresaService;

@RestController
@RequestMapping("/api/Empresas")
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
}
