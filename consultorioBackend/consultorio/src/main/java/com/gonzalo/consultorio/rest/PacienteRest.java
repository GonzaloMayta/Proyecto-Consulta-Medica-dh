package com.gonzalo.consultorio.rest;

import java.util.List;

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

import com.gonzalo.consultorio.models.Doctor;
import com.gonzalo.consultorio.models.Paciente;
import com.gonzalo.consultorio.services.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteRest {
	private final PacienteService pacienteService;

	public PacienteRest(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Paciente>> getAllPacientes() {
		List<Paciente> pacientes = pacienteService.findAllPacientes();

		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Paciente> findPacienteById(@PathVariable("id") Long id) {
		Paciente paciente = pacienteService.findpacienteById(id);
		return new ResponseEntity<>(paciente, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
		Paciente newPaciente = pacienteService.addPaciente(paciente);
		return new ResponseEntity<>(newPaciente, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente) {
		Paciente updatePaciente = pacienteService.updatepaciente(paciente);
		return new ResponseEntity<>(updatePaciente, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Paciente> deletePaciente(@PathVariable("id") Long id) {
		pacienteService.deletePaciente(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/findName/{nombre}")
	public ResponseEntity<List<Paciente>> findDoctorByName(@PathVariable("nombre") String nombre){
		List<Paciente> pacientes=pacienteService.findByNamePaciente(nombre);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}

}
