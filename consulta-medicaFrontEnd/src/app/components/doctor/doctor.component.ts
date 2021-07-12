import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/models/doctor';
import { DoctorService } from '../../services/doctor.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  public doctors: Doctor[];
  public editDoctor: Doctor;
  public deleteDoctor: Doctor;

public pagina:number=1;


  constructor(private doctorService: DoctorService) { }

  ngOnInit() {
    this.getDoctors();
  }

  public getDoctors(): void {
    this.doctorService.getDoctors().subscribe(
      (response: Doctor[]) => {
        this.doctors = response;
        console.log(this.doctors);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }


  /*Editar*/
  public onUpdateDoctor(doctor: Doctor): void {
    console.log("id: " + doctor.idDoctor)
    this.doctorService.updateDoctor(doctor).subscribe(
      (response: Doctor) => {
        this.editDoctor = response;
        this.getDoctors();
      },
      (error: HttpErrorResponse) => {
        console.log("aqui hay error");
        alert(error.message);
      }
    );

  }

  /*Eliminar */
  public onDeleteDoctor(idDoctor: number): void {
    this.doctorService.deleteDoctor(idDoctor).subscribe(
      (response: void) => {
        console.log(response);
        this.getDoctors();
      }, (error: HttpErrorResponse) => {
        console.log("aqui hay error");
        alert(error.message);
      }
    );
  }


  /* Modulo */
  public onOpenDoctor(doctor: Doctor, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'update') {
      this.editDoctor = doctor;
      button.setAttribute('data-target', '#updateDoctorModal');

      console.log(this.editDoctor.idDoctor);

    }

    if (mode === 'delete') {
      this.deleteDoctor = doctor;
      button.setAttribute('data-target', '#deleteDoctorModal');
    }
    container.appendChild(button);
    button.click();
  }
}
