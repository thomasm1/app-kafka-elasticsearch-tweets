import { TestBed } from '@angular/core/testing';

import { VaccinationService } from './vaccination.service';

describe('VaccinationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VaccinationService = TestBed.get(VaccinationService);
    expect(service).toBeTruthy();
  });
});
