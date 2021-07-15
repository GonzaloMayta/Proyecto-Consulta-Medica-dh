package com.gonzalo.consultorio.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity(name = "Consulta_Medica")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="idConsultaM")
public class Consulta_Medica implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idConsultaM")
	private Long idConsultaM;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+4")
	private Date fechaConsulta;
	private String medicamentos;

	/* Relaciones ManyToOne */

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "idDoctor"), name = "idDoctor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "idPaciente"), name = "idPaciente")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Paciente paciente;

	public Consulta_Medica() {
	}

	public Consulta_Medica(Long idConsultaM, String medicamentos, Doctor doctor, Paciente paciente) {
		this.idConsultaM = idConsultaM;
		// this.fechaConsulta = fechaConsulta;
		this.medicamentos = medicamentos;
		this.paciente = paciente;
		this.doctor = doctor;

	}

	public Long getIdConsultaM() {
		return idConsultaM;
	}

	public void setIdConsultaM(Long idConsultaM) {
		this.idConsultaM = idConsultaM;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Consulta_Medica [idConsultaM=" + idConsultaM + ", fechaConsulta=" + fechaConsulta + ", medicamentos="
				+ medicamentos + ", doctor=" + doctor + ", paciente=" + paciente + "]";
	}

}
