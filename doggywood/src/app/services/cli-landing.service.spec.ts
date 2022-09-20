import { TestBed } from '@angular/core/testing';

import { CliLandingService } from './cli-landing.service';

describe('CliLandingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CliLandingService = TestBed.get(CliLandingService);
    expect(service).toBeTruthy();
  });
});
