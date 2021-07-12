import { ConsultaMedica } from "./consulta_medica";

export class Doctor{

    idDoctor: number;
    nombre: string;
    apellido: string;
    especialidad: string;
    fechaNac: Date;
    direccion: string;
    consulta: Array<ConsultaMedica>;

}