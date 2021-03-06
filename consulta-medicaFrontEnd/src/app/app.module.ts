import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http'
import {FormsModule} from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { DoctorComponent } from './components/doctor/doctor.component';

import{DoctorService} from './services/doctor.service';

import { DoctorAddComponent } from './components/doctor-add/doctor-add.component';
import { PacienteComponent } from './components/paciente/paciente.component';
import { PacienteAdicionarComponent } from './components/paciente-adicionar/paciente-adicionar.component';
import { ConsultaMedicaComponent } from './components/consulta-medica/consulta-medica.component';

import { ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule} from 'ngx-pagination';
import { HistorialPacienteComponent } from './components/historial-paciente/historial-paciente.component';
import { DoctorAtencionComponent } from './components/doctor-atencion/doctor-atencion.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    DoctorComponent,
    DoctorAddComponent,
    PacienteComponent,
    PacienteAdicionarComponent,
    ConsultaMedicaComponent,
    HistorialPacienteComponent,
    DoctorAtencionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
  providers: [
    DoctorService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
