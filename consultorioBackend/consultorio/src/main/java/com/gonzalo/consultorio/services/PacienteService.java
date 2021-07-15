package com.gonzalo.consultorio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonzalo.consultorio.exception.UserNotFoundException;
import com.gonzalo.consultorio.models.Paciente;
import com.gonzalo.consultorio.repo.Consulta_MedicaRepo;
import com.gonzalo.consultorio.repo.PacienteRepo;

@Service
public class PacienteService {
	private final PacienteRepo pacienteRepo;

	// private final Consulta_MedicaRepo consultaRepo;
	@Autowired
	public PacienteService(PacienteRepo pacienteRepo) {
		this.pacienteRepo = pacienteRepo;
		// this.consultaRepo = consulta_MedicaRepo;
	}

	public Paciente addPaciente(Paciente paciente) {
		return pacienteRepo.save(paciente);
	}

	public List<Paciente> findAllPacientes() {
		return pacienteRepo.findAll();

	}

	public Paciente updatepaciente(Paciente paciente) {
		return pacienteRepo.save(paciente);
	}

	public Paciente findpacienteById(Long idPaciente) {

		return pacienteRepo.findById(idPaciente)
				.orElseThrow(() -> new UserNotFoundException("Paciente by idPaciente" + idPaciente + "was not found"));
	}

	public void deletePaciente(Long idPaciente) {
		pacienteRepo.deleteById(idPaciente);
	}

	public List<Paciente> findByNamePaciente( String nombrePaciente){
		return pacienteRepo.findByNombre(nombrePaciente);
	}
	
}
