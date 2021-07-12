import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Paciente } from 'src/app/models/paciente';
import { PacienteService } from 'src/app/services/paciente.service';

import {Router} from '@angular/router';
@Component({
  selector: 'app-paciente-adicionar',
  templateUrl: './paciente-adicionar.component.html',
  styleUrls: ['./paciente-adicionar.component.css']
})
export class PacienteAdicionarComponent implements OnInit {

public savePaciente: Paciente={
  idPaciente: 0,
    nombre: '',
    apellido: '',
    fechaNac: new Date(),
    direccion: '',
    consulta: []
}


  constructor(private pacienteService: PacienteService, private router: Router) { }

  ngOnInit(): void {
  }

  public addPaciente():void{
    this.pacienteService.addPaciente(this.savePaciente).subscribe(
      (response: Paciente)=>{
        this.savePaciente=response;
        this.router.navigate(['/paciente']);
      },
      (error : HttpErrorResponse)=>{
        alert(error.message);
        
      }
    );
  }

}
