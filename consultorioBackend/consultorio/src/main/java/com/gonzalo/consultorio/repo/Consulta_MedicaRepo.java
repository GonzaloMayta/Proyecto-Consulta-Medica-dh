package com.gonzalo.consultorio.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gonzalo.consultorio.models.Consulta_Medica;


@Transactional
public interface Consulta_MedicaRepo extends JpaRepository<Consulta_Medica, Long> {

	//  Pregunta 3
	
	@Query(value="SELECT * FROM consulta_medica WHERE id_doctor=:doctor_id", nativeQuery = true)
	List<Consulta_Medica> listaPacientes( Number doctor_id);
	
	
	@Query(value="select * from consulta_medica where id_doctor=:doctor_id and id_paciente=:paciente_id", nativeQuery=true)
	List<Consulta_Medica> listaConsultaPaciente( Number doctor_id, Number paciente_id);
	
	//pregunta 2 Historial
	
	@Query(value="select * from consulta_medica where id_paciente=:paciente_id", nativeQuery=true)
	List<Consulta_Medica> historialPaciente(Number paciente_id);
	
	
}
