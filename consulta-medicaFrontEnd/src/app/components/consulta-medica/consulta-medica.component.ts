import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
import { ConsultaMedica } from 'src/app/models/consulta_medica';
import { Doctor } from 'src/app/models/doctor';
import { Paciente } from 'src/app/models/paciente';
import { ConsultaMedicaService } from '../../services/consulta-medica.service';

@Component({
  selector: 'app-consulta-medica',
  templateUrl: './consulta-medica.component.html',
  styleUrls: ['./consulta-medica.component.css']
})
export class ConsultaMedicaComponent implements OnInit {

  public consultas: ConsultaMedica[];
  public saveConsulta: ConsultaMedica;
  public deleteConsulta: ConsultaMedica;
  public editConsulta: ConsultaMedica;

  pagina = 1;
  count = 0;
  nroelementos = 10;

  formConsulta = new FormGroup({
    medicamentos: new FormControl(''),
    doctor: new FormGroup({
      idDoctor: new FormControl('')
    }),
    paciente: new FormGroup({
      idPaciente: new FormControl('')
    })

  });



  constructor(private consultaMedicaService: ConsultaMedicaService) { }

  ngOnInit() {
    this.getConsutltas();
  }

  public getConsutltas(): void {
    console.log("llega aqui =>");
    this.consultaMedicaService.getConsultas().subscribe(
      (response: ConsultaMedica[]) => {
        this.consultas = response;
        console.log(this.consultas);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }


  public onaddConsulta(): void {

    let saveConsulta = new ConsultaMedica();

    let doctor = new Doctor();
    doctor.idDoctor = parseInt(this.formConsulta.value.doctor.idDoctor);

    let paciente = new Paciente();
    paciente.idPaciente = parseInt(this.formConsulta.value.paciente.idPaciente);

    saveConsulta.medicamentos = "" + (this.formConsulta.value.medicamentos);
    saveConsulta.doctor = doctor;
    saveConsulta.paciente = paciente;

    this.consultaMedicaService.addConsulta(saveConsulta).subscribe(
      (response: ConsultaMedica) => {
        this.saveConsulta = response;
        this.getConsutltas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  /*Eliminar */
  public onDeleteConsulta(idConsulta: number): void {
    this.consultaMedicaService.deleteConsulta(idConsulta).subscribe(
      (response: void) => {
        console.log(response);
        this.getConsutltas();
      }, (error: HttpErrorResponse) => {
        console.log("aqui hay error");
        alert(error.message);
      }
    );
  }


  /* Modulo */
  public onOpenConsulta(consulta: ConsultaMedica, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'add') {
      this.saveConsulta = consulta;
      button.setAttribute('data-target', '#AddConsultaModal');
    }
    if (mode === 'delete') {
      this.deleteConsulta = consulta;
      button.setAttribute('data-target', '#deleteDoctorModal');
    }
    container.appendChild(button);
    button.click();
  }


  handlePageChange(event: number): void {
    this.pagina = event;
    this.getConsutltas();
  }
}
