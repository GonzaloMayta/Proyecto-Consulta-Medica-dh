package com.gonzalo.consultorio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalo.consultorio.models.Consulta_Medica;
import com.gonzalo.consultorio.services.Consulta_MedicaService;

@RestController
@RequestMapping("/consulta")
public class Consulta_MedicaRest {
	@Autowired
	private  Consulta_MedicaService consulta_MedicaService;

	public Consulta_MedicaRest(Consulta_MedicaService consulta) {
		this.consulta_MedicaService = consulta;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Consulta_Medica>> getAllConsultas() {
		List<Consulta_Medica> consultas = consulta_MedicaService.getAllConsultas();
		return new ResponseEntity<>(consultas, HttpStatus.OK);
	}

	
	@PostMapping("/add")
	public ResponseEntity<Consulta_Medica> addConsulta(@RequestBody Consulta_Medica consulta) {
		Consulta_Medica newConsulta = consulta_MedicaService.addConsulta(consulta);
		return new ResponseEntity<>(newConsulta, HttpStatus.OK);
	}


	@PutMapping("/update")
	public ResponseEntity<Consulta_Medica> updateConsulta(@RequestBody Consulta_Medica consulta) {
		Consulta_Medica updateConsulta = consulta_MedicaService.updateConsulta(consulta);
		return new ResponseEntity<>(updateConsulta, HttpStatus.OK);
	}
	
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<Consulta_Medica>  deleteConsulta(@PathVariable("id") Long id) {
	  consulta_MedicaService.deleteConsulta(id);
	  return new ResponseEntity<>(HttpStatus.OK); 
	  }
	 
	  @GetMapping("/ordenado")
		public ResponseEntity<List<Consulta_Medica>> OrderByFecha() {
			List<Consulta_Medica> consultas = consulta_MedicaService.OrderByFecha();
			return new ResponseEntity<>(consultas, HttpStatus.OK);
		}
	  /*Listamos Pacientes*/
	  @GetMapping("/listapaciente/{iddoctor}")
		public ResponseEntity<List<Consulta_Medica>> listarPacientes(@PathVariable("iddoctor") Number iddoctor) {
			List<Consulta_Medica> listaP = consulta_MedicaService.listarPacientes(iddoctor);
			return new ResponseEntity<>(listaP, HttpStatus.OK);
		}
	  
	  
	  /*Listamos consulta de Paciente*/
	  @GetMapping("/listapaciente/{iddoctor}/{idpaciente}")
		public ResponseEntity<List<Consulta_Medica>> listaConsultaPaciente(@PathVariable("iddoctor") Number iddoctor, @PathVariable("idpaciente") Number idpaciente) {
			List<Consulta_Medica> listaP = consulta_MedicaService.listaConsultaPaciente(iddoctor,idpaciente);
			return new ResponseEntity<>(listaP, HttpStatus.OK);
		}
	  
	  
	  /*Historial clinico de Paciente*/
	  @GetMapping("/historial/{idpaciente}")
		public ResponseEntity<List<Consulta_Medica>> historialPaciente(@PathVariable("idpaciente") Number idpaciente) {
			List<Consulta_Medica> historial = consulta_MedicaService.historialPaciente(idpaciente);
			return new ResponseEntity<>(historial, HttpStatus.OK);
		}
	  
}
