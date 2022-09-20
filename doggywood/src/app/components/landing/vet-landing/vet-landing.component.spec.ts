import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VetLandingComponent } from './vet-landing.component';

describe('VetLandingComponent', () => {
  let component: VetLandingComponent;
  let fixture: ComponentFixture<VetLandingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VetLandingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VetLandingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    console.log("test-VetLandingComponent")
    //  expect(component).toBeTruthy();
  });
});
