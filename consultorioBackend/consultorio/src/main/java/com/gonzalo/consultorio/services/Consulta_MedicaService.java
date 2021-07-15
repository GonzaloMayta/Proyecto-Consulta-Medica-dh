package com.gonzalo.consultorio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gonzalo.consultorio.models.Consulta_Medica;
import com.gonzalo.consultorio.models.Doctor;
import com.gonzalo.consultorio.models.Paciente;
import com.gonzalo.consultorio.repo.Consulta_MedicaRepo;
import com.gonzalo.consultorio.repo.DoctorRepo;
import com.gonzalo.consultorio.repo.PacienteRepo;

@Service
public class Consulta_MedicaService {
	@Autowired
	private Consulta_MedicaRepo consulta_MedicaRepo;
	@Autowired
	private DoctorRepo doctorRepo;
	@Autowired
	private PacienteRepo pacienteRepo;

	
	public List<Consulta_Medica> getAllConsultas() {
		return consulta_MedicaRepo.findAll();
	}

	public Consulta_Medica addConsulta(Consulta_Medica consulta_Medica) {

		Doctor doctorE = doctorRepo.findById(consulta_Medica.getDoctor().getIdDoctor()).orElse(null);
		if (doctorE == null) {
			doctorE = new Doctor();

			doctorE.setNombre(consulta_Medica.getDoctor().getNombre());
			doctorE.setApellido(consulta_Medica.getDoctor().getApellido());
			doctorE.setFechaNac(consulta_Medica.getDoctor().getFechaNac());
			doctorE.setDireccion(consulta_Medica.getDoctor().getDireccion());
			doctorE.setEspecialidad(consulta_Medica.getDoctor().getEspecialidad());
		}
		consulta_Medica.setDoctor(doctorE);

		Paciente pacienteC = pacienteRepo.findById(consulta_Medica.getPaciente().getIdPaciente()).orElse(null);
		if (pacienteC == null) {
			pacienteC = new Paciente();

			pacienteC.setNombre(consulta_Medica.getPaciente().getNombre());
			pacienteC.setApellido(consulta_Medica.getPaciente().getApellido());
			pacienteC.setFechaNac(consulta_Medica.getPaciente().getFechaNac());
			pacienteC.setDireccion(consulta_Medica.getPaciente().getDireccion());

		}

		consulta_Medica.setPaciente(pacienteC);
		return consulta_MedicaRepo.save(consulta_Medica);
	}

	public Consulta_Medica updateConsulta(Consulta_Medica consulta_Medica) {
		return consulta_MedicaRepo.save(consulta_Medica);
	}

	public void deleteConsulta(Long idConsulta) {
		consulta_MedicaRepo.deleteById(idConsulta);
	}

	public List<Consulta_Medica> OrderByFecha() {
		
		List<Consulta_Medica> ordenado = consulta_MedicaRepo.findAll(Sort.by(Sort.Direction.DESC, "fechaConsulta"));
		return ordenado;
	}

	public List<Consulta_Medica> listarPacientes(Number doctor_id) {

		List<Consulta_Medica> lista = consulta_MedicaRepo.listaPacientes(doctor_id);
		return lista;
	}

	public List<Consulta_Medica> listaConsultaPaciente(Number doctor_id, Number paciente_id) {

		List<Consulta_Medica> listaConsulta = consulta_MedicaRepo.listaConsultaPaciente(doctor_id, paciente_id);

		return listaConsulta;
	}

	public List<Consulta_Medica> historialPaciente( Number paciente_id) {

		List<Consulta_Medica> historial = consulta_MedicaRepo.historialPaciente(paciente_id);
		return historial;
	}

}
