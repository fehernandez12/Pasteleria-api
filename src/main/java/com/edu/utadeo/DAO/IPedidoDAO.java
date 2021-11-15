package com.edu.utadeo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Pedido;

public interface IPedidoDAO extends JpaRepository<Pedido, Long> {

}
