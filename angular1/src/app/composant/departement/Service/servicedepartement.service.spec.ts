import { TestBed } from '@angular/core/testing';

import { ServicedepartementService } from './servicedepartement.service';

describe('ServicedepartementService', () => {
  let service: ServicedepartementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicedepartementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
