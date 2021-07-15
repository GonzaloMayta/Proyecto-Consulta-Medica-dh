import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from '../models/doctor';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  
  private apiServerUrl=environment.apiServerUrl;
  constructor(private http: HttpClient) { }

  public getDoctors():Observable<Doctor[]>{
    return this.http.get<Doctor[]>(`${this.apiServerUrl}/doctor/all`);
  }


  public addDoctor(doctor: Doctor):Observable<Doctor>{
    return this.http.post<Doctor>(`${this.apiServerUrl}/doctor/add`,doctor);
  }

  public updateDoctor(doctor: Doctor):Observable<Doctor>{
    return this.http.put<Doctor>(`${this.apiServerUrl}/doctor/update`,doctor);
  }

  public deleteDoctor(idDoctor: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/doctor/delete/${idDoctor}`);
  }
  

  public findNameDoctor(nombre: string):Observable<Doctor[]>{
    return this.http.get<Doctor[]>(`${this.apiServerUrl}/doctor/findName/${nombre}`);
  }




}
