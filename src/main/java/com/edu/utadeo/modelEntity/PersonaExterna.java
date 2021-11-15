package com.edu.utadeo.modelEntity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas_externas")
public class PersonaExterna {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	private int cedula;
	private String nombres;
	private String apellidos;
	private String dir;
	private Date fechaNac;
}
