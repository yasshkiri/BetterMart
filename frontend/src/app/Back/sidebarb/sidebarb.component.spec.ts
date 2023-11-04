import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarbComponent } from './sidebarb.component';

describe('SidebarbComponent', () => {
  let component: SidebarbComponent;
  let fixture: ComponentFixture<SidebarbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidebarbComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SidebarbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
