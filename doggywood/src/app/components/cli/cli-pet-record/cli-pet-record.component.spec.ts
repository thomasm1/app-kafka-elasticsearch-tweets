import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CliPetRecordComponent } from './cli-pet-record.component';

describe('CliPetRecordComponent', () => {
  let component: CliPetRecordComponent;
  let fixture: ComponentFixture<CliPetRecordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CliPetRecordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CliPetRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    console.log("test-CliPetRecordComponent")
    //    expect(component).toBeTruthy();
  });
});
