import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaFormComponent } from './ca-form.component';

describe('CaFormComponent', () => {
  let component: CaFormComponent;
  let fixture: ComponentFixture<CaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CaFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
