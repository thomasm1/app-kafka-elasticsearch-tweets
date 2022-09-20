import { TestBed } from '@angular/core/testing';

import { VaccRecordService } from './vacc-record.service';

describe('VaccRecordService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VaccRecordService = TestBed.get(VaccRecordService);
    expect(service).toBeTruthy();
  });
});
