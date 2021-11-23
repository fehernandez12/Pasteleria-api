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
import com.edu.utadeo.modelEntity.TipoEmpleado;
import com.edu.utadeo.services.ITipoEmpleadoService;

@RestController
@RequestMapping("/api/tipo_empleado")
@CrossOrigin(origins="*", allowedHeaders="*")
public class TipoEmpleadoController {
	@Autowired
	private ITipoEmpleadoService tipoEmpleadoService;
	
	@GetMapping("/")
	public List<TipoEmpleado> FindAll(){
		return tipoEmpleadoService.findAll();
	}
	
	@GetMapping("/{id}")
	public TipoEmpleado detail(@PathVariable Long id) {
		return tipoEmpleadoService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody TipoEmpleado d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		TipoEmpleado te = new TipoEmpleado();
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
			te = d;
			d = tipoEmpleadoService.save(te);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TipoEmpleado>(te, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tipoEmpleadoService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public TipoEmpleado update(@PathVariable Long id, @RequestBody TipoEmpleado e) {
		TipoEmpleado actual = tipoEmpleadoService.findById(id);
		actual.setId(e.getId());
		actual.setDescripcion(e.getDescripcion());
		return tipoEmpleadoService.save(actual);
	}

}