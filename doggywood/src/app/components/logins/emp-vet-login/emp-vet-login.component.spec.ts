import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpVetLoginComponent } from './emp-vet-login.component';

describe('EmpVetLoginComponent', () => {
  let component: EmpVetLoginComponent;
  let fixture: ComponentFixture<EmpVetLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpVetLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpVetLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    console.log("test-EmpVetLoginComponent")
    //     expect(component).toBeTruthy();
  });
});
