import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Paciente } from 'src/app/models/paciente';

import { PacienteService } from '../../services/paciente.service';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css']
})
export class PacienteComponent implements OnInit {

  public pacientes: Paciente[];
  public editPaciente: Paciente;
  public deletePaciente: Paciente;
  constructor(private pacienteService: PacienteService) { }

  ngOnInit(): void {
    this.getPacientes();
  }

  public getPacientes(): void {
    this.pacienteService.getPacientes().subscribe(
      (response: Paciente[]) => {
        this.pacientes = response;
        console.log(this.pacientes);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  
  /*Editar*/
  public onUpdatePaciente(paciente: Paciente): void {
    console.log("id: " + paciente.idPaciente)
    this.pacienteService.updatePaciente(paciente).subscribe(
      (response: Paciente) => {
        this.editPaciente = response;
        this.getPacientes();
      },
      (error: HttpErrorResponse) => {
        console.log("aqui hay error");
        alert(error.message);
      }
    );

  }

  /*Eliminar */
  public onDeletePaciente(idPaciente: number): void {
    this.pacienteService.deletePaciente(idPaciente).subscribe(
      (response: void) => {
        console.log(response);
        this.getPacientes();
      }, (error: HttpErrorResponse) => {
        console.log("aqui hay error");
        alert(error.message);
      }
    );
  }


  /* Modulo */
  public onOpenPaciente(paciente: Paciente, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'update') {
      this.editPaciente = paciente;
      button.setAttribute('data-target', '#updatePacienteModal');

      console.log(this.editPaciente.idPaciente);

    }

    if (mode === 'delete') {
      this.deletePaciente = paciente;
      button.setAttribute('data-target', '#deletePacienteModal');
    }
    container.appendChild(button);
    button.click();
  }



}
