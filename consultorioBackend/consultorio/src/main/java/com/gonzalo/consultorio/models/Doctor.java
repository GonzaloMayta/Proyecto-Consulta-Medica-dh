package com.gonzalo.consultorio.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name ="doctors")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="idDoctor")
public class Doctor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDoctor")
	//JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Integer idDoctor;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "apellido", length = 50)
	private String apellido;
	private String especialidad;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaNac;
	private String direccion;
	// private String fotografia;

	/* Relacion OneToMany */
	@OneToMany(mappedBy = "doctor",  cascade = CascadeType.ALL, orphanRemoval = false)
	@JsonIgnore
	private List<Consulta_Medica> consulta;
	
	
	
	
	
	public Doctor() {
	}

	public Doctor(Integer idDoctor, String nombre, String apellido, String especialidad, Date fechaNac, String direccion) {
		this.idDoctor = idDoctor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		// this.fotografia = fotografia;
	}

	public Integer getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Integer idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Consulta_Medica> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta_Medica> consulta) {
		this.consulta = consulta;
	}

	/*
	 * public String getFotografia() { return fotografia; }
	 * 
	 * public void setFotografia(String fotografia) { this.fotografia = fotografia;
	 * }
	 */
	@Override
	public String toString() {
		return "Doctor [idDoctor=" + idDoctor + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad="
				+ especialidad + ", fechaNac=" + fechaNac + ", direccion=" + direccion + "]";
	}

}
