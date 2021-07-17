import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { DoctorComponent } from './components/doctor/doctor.component';
import { DoctorAddComponent } from './components/doctor-add/doctor-add.component';
import { PacienteComponent } from './components/paciente/paciente.component';
import { PacienteAdicionarComponent } from './components/paciente-adicionar/paciente-adicionar.component';
import { ConsultaMedicaComponent } from './components/consulta-medica/consulta-medica.component';
import { HistorialPacienteComponent } from './components/historial-paciente/historial-paciente.component';
import { DoctorAtencionComponent} from './components/doctor-atencion/doctor-atencion.component'
const routes: Routes = [
  {
    path: '',
    redirectTo: '/doctor',
    pathMatch: 'full'

  }, {
    path: 'doctor',
    component: DoctorComponent
  },
  {
    path: 'doctor/all',
    component: DoctorComponent
  },
  {
    path: 'doctor/add',
    component: DoctorAddComponent
  },

  {
    path: 'paciente',
    component: PacienteComponent
  },
  {
    path: 'paciente/add',
    component: PacienteAdicionarComponent
  },
  {
    path: 'consulta',
    component: ConsultaMedicaComponent
  },
  {
    path:'historialpac/:idPaciente',
    component: HistorialPacienteComponent
  },
  {
    path:'consultasmedicas/:idDoctor',
    component: DoctorAtencionComponent
  },
  {
    path:'historialpacdoc/:idDoctor/:idPaciente',
    component: HistorialPacienteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
