import { TestBed } from '@angular/core/testing';

import { ServiceuniversiteService } from './serviceuniversite.service';

describe('ServiceuniversiteService', () => {
  let service: ServiceuniversiteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceuniversiteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
