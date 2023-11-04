import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelysComponent } from './relys.component';

describe('RelysComponent', () => {
  let component: RelysComponent;
  let fixture: ComponentFixture<RelysComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RelysComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RelysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
