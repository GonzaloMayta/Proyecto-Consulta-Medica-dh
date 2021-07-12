import { Doctor } from "./doctor";
import { Paciente } from "./paciente";

export class ConsultaMedica{
    idConsultaM: number;
    fechaConsulta: Date;
    medicamentos: string;
    doctor: Doctor;
    paciente: Paciente;
   
    /**
     * C
     */
    public ConsultaMedica(medicamentos: string, idDoctor: number, idPaciente: number) {
        this.idConsultaM =0;
        this.fechaConsulta=new Date;
        this.medicamentos=medicamentos;
        this.doctor=new Doctor;
        this.doctor.idDoctor=idDoctor;
        this.paciente = new Paciente;
        this.paciente.idPaciente=idPaciente;
    }
}