import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NbretudiantComponent } from './nbretudiant.component';

describe('NbretudiantComponent', () => {
  let component: NbretudiantComponent;
  let fixture: ComponentFixture<NbretudiantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NbretudiantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NbretudiantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
