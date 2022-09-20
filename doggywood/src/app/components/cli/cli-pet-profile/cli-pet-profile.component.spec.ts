import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CliPetProfileComponent } from './cli-pet-profile.component';

describe('CliPetProfileComponent', () => {
  let component: CliPetProfileComponent;
  let fixture: ComponentFixture<CliPetProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CliPetProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CliPetProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    console.log("test-CliPetProfileComponent")
    //     expect(component).toBeTruthy();
  });
});
