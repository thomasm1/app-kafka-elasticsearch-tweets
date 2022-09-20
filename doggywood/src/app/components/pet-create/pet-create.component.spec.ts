import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetCreateComponent } from './pet-create.component';

describe('PetCreateComponent', () => {
  let component: PetCreateComponent;
  let fixture: ComponentFixture<PetCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   console.log("test-PetCreateComponent");
  //   //   expect(component).toBeTruthy();
  // });
});
