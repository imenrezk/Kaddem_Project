import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterequipeComponent } from './ajouterequipe.component';

describe('AjouterequipeComponent', () => {
  let component: AjouterequipeComponent;
  let fixture: ComponentFixture<AjouterequipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjouterequipeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjouterequipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
