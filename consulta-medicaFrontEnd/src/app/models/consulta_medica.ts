import { Doctor } from "./doctor";
import { Paciente } from "./paciente";

export class ConsultaMedica{
    idConsultaM: number;
    fechaConsulta: Date;
    medicamentos: string;
    doctor: Doctor;
    paciente: Paciente;
   
    
}