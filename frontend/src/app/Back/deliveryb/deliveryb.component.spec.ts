import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliverybComponent } from './deliveryb.component';

describe('DeliverybComponent', () => {
  let component: DeliverybComponent;
  let fixture: ComponentFixture<DeliverybComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeliverybComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeliverybComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
