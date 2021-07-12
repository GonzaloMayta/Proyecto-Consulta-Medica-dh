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
import com.gonzalo.consultorio.services.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorRest {
	private final DoctorService doctorService;
	

	public DoctorRest(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctors = doctorService.findAllDoctors();
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") Integer id) {
		Doctor doctor = doctorService.findDoctorById(id);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		Doctor newDoctor = doctorService.addDoctor(doctor);
		return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
		Doctor updateDoctor = doctorService.updateDoctor(doctor);
		return new ResponseEntity<>(updateDoctor, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDoctorById(@PathVariable("id") Integer id) {
		doctorService.deleteDoctor(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
