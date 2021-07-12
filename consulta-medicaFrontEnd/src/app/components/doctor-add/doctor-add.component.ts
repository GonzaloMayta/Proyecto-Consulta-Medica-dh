import { HttpErrorResponse } from '@angular/common/http';
import { Component, HostBinding, OnInit } from '@angular/core';

import { Doctor } from 'src/app/models/doctor';

import { DoctorService } from '../../services/doctor.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-doctor-add',
  templateUrl: './doctor-add.component.html',
  styleUrls: ['./doctor-add.component.css']
})
export class DoctorAddComponent implements OnInit {

@HostBinding('class') classes='row';


public savedoctor: Doctor={
  idDoctor: 0,
  nombre: '',
  apellido: '',
  especialidad:'',
  fechaNac: new Date(),
  direccion: '',
  consulta: []
  
};

  constructor(private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
  }

  public addDoctor(): void{
    this.doctorService.addDoctor(this.savedoctor).subscribe(
      (response : Doctor)=>{
        this.savedoctor=response;
        //console.log();
        this.router.navigate(['/doctor']);
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )



  }

}
