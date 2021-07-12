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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="pacientes")
public class Paciente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPaciente")
	private Long idPaciente;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "apellido", length = 50)
	private String apellido;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaNac;
	private String direccion;
	// private String fotografia;

	/* Relacion OneToMany */
	@OneToMany(mappedBy = "paciente", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Consulta_Medica> consulta;
	
	public Paciente() {
	}

	public Paciente(Long idPaciente, String nombre, String apellido, Date fechaNac, String direccion,
			String fotografia) {
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		// this.fotografia = fotografia;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
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

/*	
	public List<Consulta_Medica> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta_Medica> consulta) {
		this.consulta = consulta;
	}
*/
	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac="
				+ fechaNac + ", direccion=" + direccion + "]";
	}

}
