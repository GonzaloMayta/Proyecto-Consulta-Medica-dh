package com.gonzalo.consultorio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonzalo.consultorio.exception.UserNotFoundException;
import com.gonzalo.consultorio.models.Doctor;
import com.gonzalo.consultorio.repo.Consulta_MedicaRepo;
import com.gonzalo.consultorio.repo.DoctorRepo;

@Service
public class DoctorService {
	private final DoctorRepo doctorRepo;
	//private final Consulta_MedicaRepo consultaRepo;
	@Autowired
	public DoctorService(DoctorRepo doctorRepo) {
		this.doctorRepo = doctorRepo;
		//this.consultaRepo = consulta_MedicaRepo;
	}

	public Doctor addDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	public List<Doctor> findAllDoctors() {
		return doctorRepo.findAll();

	}

	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	
	public Doctor findDoctorById(Integer idDoctor) {

		return doctorRepo.findById(idDoctor).orElseThrow(() -> new UserNotFoundException("Doctor con idDoctor" + idDoctor + "no fue encontrado"));
	}

	public void deleteDoctor(Integer idDoctor) {
		doctorRepo.deleteById(idDoctor);
		//deleteDoctorById(idDoctor);
	}
	
	public List<Doctor> findByNameDoctor(String nombre) {
		return doctorRepo.findByNombre(nombre);
	}

}
