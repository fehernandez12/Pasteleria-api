package com.edu.utadeo.modelEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
}
