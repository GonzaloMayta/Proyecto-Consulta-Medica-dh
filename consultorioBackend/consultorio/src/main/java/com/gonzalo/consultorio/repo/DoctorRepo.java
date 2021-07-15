package com.gonzalo.consultorio.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.consultorio.models.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	//**Doctor findByName(String name);
	
	//Optional<Doctor> findDoctorById(Long idDoctor);

	//void deleteDoctorById(Long idDoctor);

	List<Doctor> findByNombre(String nombre);

	
}
