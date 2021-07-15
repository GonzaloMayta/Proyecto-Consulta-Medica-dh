package com.gonzalo.consultorio.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.consultorio.models.Paciente;

public interface PacienteRepo extends JpaRepository<Paciente, Long>{

	List<Paciente> findByNombre(String nombrePaciente);
	
}
