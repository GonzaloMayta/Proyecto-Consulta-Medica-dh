import { ConsultaMedica } from "./consulta_medica";

export class Paciente{
    idPaciente: number;
    nombre: string;
    apellido: string;
    fechaNac: Date;
    direccion: string;
    consulta: Array<ConsultaMedica>;
    
}