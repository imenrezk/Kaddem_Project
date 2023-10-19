import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditdepartementComponent } from './editdepartement.component';

describe('EditdepartementComponent', () => {
  let component: EditdepartementComponent;
  let fixture: ComponentFixture<EditdepartementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditdepartementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditdepartementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
