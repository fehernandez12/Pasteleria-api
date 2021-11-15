package com.edu.utadeo.modelEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaSolicitud;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaEntrega;
}
