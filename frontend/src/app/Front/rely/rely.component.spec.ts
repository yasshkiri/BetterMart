import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelyComponent } from './rely.component';

describe('RelyComponent', () => {
  let component: RelyComponent;
  let fixture: ComponentFixture<RelyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RelyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RelyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
