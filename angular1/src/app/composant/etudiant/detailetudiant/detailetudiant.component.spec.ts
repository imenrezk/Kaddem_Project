import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailetudiantComponent } from './detailetudiant.component';

describe('DetailetudiantComponent', () => {
  let component: DetailetudiantComponent;
  let fixture: ComponentFixture<DetailetudiantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailetudiantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailetudiantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
