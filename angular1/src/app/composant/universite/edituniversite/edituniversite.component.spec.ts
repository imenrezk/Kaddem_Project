import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdituniversiteComponent } from './edituniversite.component';

describe('EdituniversiteComponent', () => {
  let component: EdituniversiteComponent;
  let fixture: ComponentFixture<EdituniversiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EdituniversiteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EdituniversiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
