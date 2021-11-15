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
	public EtapaPastel save(@RequestBody EtapaPastel l) {
		return etapaPastelService.save(l);
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
