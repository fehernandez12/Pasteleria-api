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
import com.edu.utadeo.modelEntity.TipoPastel;
import com.edu.utadeo.services.ITipoPastelService;

@RestController
@RequestMapping("/api/tipo_Pastel")
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
	public TipoPastel save(@RequestBody TipoPastel e) {
		return tipoPastelService.save(e);
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