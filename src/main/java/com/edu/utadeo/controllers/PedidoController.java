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
import com.edu.utadeo.modelEntity.Pedido;
import com.edu.utadeo.services.IEmpleadoService;
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
}
