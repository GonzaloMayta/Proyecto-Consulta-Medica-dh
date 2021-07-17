import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorAtencionComponent } from './doctor-atencion.component';

describe('DoctorAtencionComponent', () => {
  let component: DoctorAtencionComponent;
  let fixture: ComponentFixture<DoctorAtencionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorAtencionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorAtencionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
