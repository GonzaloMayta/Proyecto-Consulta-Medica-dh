import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { ConsultaMedica } from 'src/app/models/consulta_medica';
import { ConsultaMedicaService } from 'src/app/services/consulta-medica.service';

@Component({
  selector: 'app-doctor-atencion',
  templateUrl: './doctor-atencion.component.html',
  styleUrls: ['./doctor-atencion.component.css']
})
export class DoctorAtencionComponent implements OnInit {

  public consultasMedicas: ConsultaMedica[];
  idDoctor: number;

  constructor(private consultaService: ConsultaMedicaService, private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      (parametros: Params) => {
        this.idDoctor = parseInt(parametros.idDoctor);
        this.getConsultasMedicas(this.idDoctor);
        console.log("Doctor is here");
      }
    )

  }

  public getConsultasMedicas(idDoctor: number) {
    this.consultaService.consultasMedicas(idDoctor).subscribe(
      (response: ConsultaMedica[]) => {
        this.consultasMedicas = response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );

  }

  public pacientSelected(){
    console.log("paciente selecionado");
  }


}
