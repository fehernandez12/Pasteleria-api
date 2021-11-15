package com.edu.utadeo.controllers;

import java.util.List;

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
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa save(@RequestBody Empresa e) {
		return empresaService.save(e);
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
