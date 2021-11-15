package com.edu.utadeo.modelEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pasteles")
public class Pastel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	
	@Column
	private String nombre;
	
	@Column
	private String tipo;
	
	@Column
	private short pesoMin;
	
	@Column
	private Date fechaSolicitud;
	
	@Column
	private Date fechaEntrega;
	
	@Column
	private String adicional;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_empleado.id")
	private Empleado empleado;
	//Getters and Setters
	
	
}
