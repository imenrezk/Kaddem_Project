import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierequipeComponent } from './modifierequipe.component';

describe('ModifierequipeComponent', () => {
  let component: ModifierequipeComponent;
  let fixture: ComponentFixture<ModifierequipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifierequipeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifierequipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
