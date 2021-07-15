import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Paciente } from '../models/paciente';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {
  private apiServerUrl=environment.apiServerUrl;
  constructor(private http: HttpClient) { }


  public getPacientes():Observable<Paciente[]>{
    return this.http.get<Paciente[]>(`${this.apiServerUrl}/paciente/all`);
  }

  public addPaciente(nuevoPaciente:Paciente):Observable<Paciente>{
    return this.http.post<Paciente>(`${this.apiServerUrl}/paciente/add`,nuevoPaciente);
  }

  public updatePaciente(paciente:Paciente):Observable<Paciente>{
    return this.http.put<Paciente>(`${this.apiServerUrl}/paciente/update`,paciente);
  }

  public deletePaciente(idPaciente: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/paciente/delete/${idPaciente}`);
  }
  public findNameDoctor(nombre: string):Observable<Paciente[]>{
    return this.http.get<Paciente[]>(`${this.apiServerUrl}/paciente/findName/${nombre}`);
  }
}
