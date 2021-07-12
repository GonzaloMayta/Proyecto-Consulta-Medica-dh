package com.gonzalo.consultorio.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.consultorio.models.Consulta_Medica;
import com.gonzalo.consultorio.models.Doctor;

public interface Consulta_MedicaRepo extends JpaRepository<Consulta_Medica, Long> {

	//void deleteConsulta_MedicaById(Long idConsulta);

//	Optional<Consulta_Medica> findConsulta_MedicaById(Long idConsulta);

	//**List<Consulta_Medica> findByDoctor(Doctor doctor,Sort sort);
}
