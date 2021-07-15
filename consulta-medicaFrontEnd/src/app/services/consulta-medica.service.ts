import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ConsultaMedica } from '../models/consulta_medica';

@Injectable({
  providedIn: 'root'
})
export class ConsultaMedicaService {

  private apiServerUrl = environment.apiServerUrl;
  constructor(private http: HttpClient) { }

  public getConsultas(): Observable<ConsultaMedica[]> {
    console.log("is here");
    return this.http.get<ConsultaMedica[]>(`${this.apiServerUrl}/consulta/ordenado`);
  }

  public addConsulta(consulta: ConsultaMedica): Observable<ConsultaMedica> {
    return this.http.post<ConsultaMedica>(`${this.apiServerUrl}/consulta/add`, consulta);
  }

  public updateConsulta(consulta: ConsultaMedica): Observable<ConsultaMedica> {
    return this.http.put<ConsultaMedica>(`${this.apiServerUrl}/consulta/update`, consulta);
  }

  public deleteConsulta(idConsulta: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/consulta/delete/${idConsulta}`);
  }
}
