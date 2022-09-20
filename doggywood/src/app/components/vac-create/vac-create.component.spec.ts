import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VacCreateComponent } from './vac-create.component';

describe('VacCreateComponent', () => {
  let component: VacCreateComponent;
  let fixture: ComponentFixture<VacCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VacCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VacCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    console.log("test-VacCreateComponent")
    //  expect(component).toBeTruthy();
  });
});
