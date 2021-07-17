import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { ConsultaMedica } from 'src/app/models/consulta_medica';
import { ConsultaMedicaService } from 'src/app/services/consulta-medica.service';

@Component({
  selector: 'app-historial-paciente',
  templateUrl: './historial-paciente.component.html',
  styleUrls: ['./historial-paciente.component.css']
})
export class HistorialPacienteComponent implements OnInit {

  public historial: ConsultaMedica[];

  public idPaciente: number;
  public idDoctor: number;

  constructor(private consultaService: ConsultaMedicaService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe(
      (parametros: Params) => {
        if (parametros.idPaciente != null && parametros.idPaciente === null) {
          this.idPaciente = parseInt(parametros.idPaciente);
          this.getHistorial(this.idPaciente);
        }
        if (parametros.idDoctor != null && parametros.idPaciente != null) {
          this.idDoctor = parseInt(parametros.idDoctor);
          this.idPaciente = parseInt(parametros.idPaciente);
          this.getvalor(this.idDoctor, this.idPaciente);
        }
      });

  }

  public getHistorial(idPaciente: number) {
    this.consultaService.historialPaciente(idPaciente).subscribe(
      (response: ConsultaMedica[]) => {
        this.historial = response;
        console.log(this.historial);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }

  public getvalor(doctorid: number, pacienteid: number) {
    this.consultaService.doctorPaciente(doctorid, pacienteid).subscribe(
      (response: ConsultaMedica[]) => {
        this.historial = response;
        console.log(this.historial);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}

