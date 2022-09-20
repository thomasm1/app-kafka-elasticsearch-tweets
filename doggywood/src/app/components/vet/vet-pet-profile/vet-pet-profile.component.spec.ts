import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VetPetProfileComponent } from './vet-pet-profile.component';

describe('VetPetProfileComponent', () => {
  let component: VetPetProfileComponent;
  let fixture: ComponentFixture<VetPetProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VetPetProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VetPetProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    console.log("test-VetPetProfileComponent")
    // expect(component).toBeTruthy();
  });
});
