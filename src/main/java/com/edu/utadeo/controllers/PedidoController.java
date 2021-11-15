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
import com.edu.utadeo.modelEntity.Pedido;
import com.edu.utadeo.services.IPedidoService;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PedidoController {
	@Autowired
	private IPedidoService pedidoService;
	
	@GetMapping("/")
	public List<Pedido> FindAll(){
		return pedidoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Pedido detail(@PathVariable long id) {
		return pedidoService.findById(id);
	}
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido save(@RequestBody Pedido e) {
		return pedidoService.save(e);
	}
	
	@DeleteMapping("/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		pedidoService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pedido update(@PathVariable long id, @RequestBody Pedido e) {
		Pedido actual = pedidoService.findById(id);
		actual.setFechaSolicitud(e.getFechaSolicitud());
		actual.setFechaEntrega(e.getFechaEntrega());
		actual.setEmpleado(e.getEmpleado());
		return pedidoService.save(actual);
	}
}
