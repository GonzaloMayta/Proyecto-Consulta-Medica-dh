package com.gonzalo.consultorio.repo;

import java.util.List;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gonzalo.consultorio.models.Consulta_Medica;
import com.gonzalo.consultorio.models.Doctor;

@Transactional
public interface Consulta_MedicaRepo extends JpaRepository<Consulta_Medica, Long> {

	//List<Consulta_Medica> OrderByfechaConsulta();
	
	@Query(value="SELECT * FROM consulta_medica WHERE id_doctor=:doctor_id", nativeQuery = true)
	List<Consulta_Medica> listaPaciente( Number doctor_id);
	
}
