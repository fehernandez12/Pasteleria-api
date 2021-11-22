package com.edu.utadeo.modelEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name="personas_externas")
public class PersonaExterna implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@NotNull
	@Column
	private int cedula;
	
	@NotNull
	@Column
	private String nombres;
	
	@NotNull
	@Column
	private String apellidos;
	
	@NotNull
	@Column
	private String dir;
	
	@NotNull
	@Column
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaNac;
	
	@OneToOne
	@JoinColumn(name="persona")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Persona persona;
	
	//Getters and Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
}
