import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { DoctorComponent }from './components/doctor/doctor.component';
import {DoctorAddComponent} from './components/doctor-add/doctor-add.component';
import {PacienteComponent} from './components/paciente/paciente.component';
import { PacienteAdicionarComponent } from './components/paciente-adicionar/paciente-adicionar.component';
import { ConsultaMedicaComponent } from './components/consulta-medica/consulta-medica.component';
const routes: Routes = [
  {
    path: '',
    redirectTo:'/doctor',
    pathMatch:'full'

  },{
    path: 'doctor',
    component:DoctorComponent
  },
  {
    path: 'doctor/all',
    component:DoctorComponent
  },
  {
    path: 'doctor/add',
    component:DoctorAddComponent
  },
 
  {
    path: 'paciente',
    component:PacienteComponent
  },
  {
    path: 'paciente/add',
    component:PacienteAdicionarComponent
  }, 
  {
    path: 'consulta',
    component: ConsultaMedicaComponent
    }
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
