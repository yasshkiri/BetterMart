import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelybComponent } from './relyb.component';

describe('RelybComponent', () => {
  let component: RelybComponent;
  let fixture: ComponentFixture<RelybComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RelybComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RelybComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
