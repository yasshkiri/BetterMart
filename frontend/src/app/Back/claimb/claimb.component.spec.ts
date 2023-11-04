import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimbComponent } from './claimb.component';

describe('ClaimbComponent', () => {
  let component: ClaimbComponent;
  let fixture: ComponentFixture<ClaimbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClaimbComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClaimbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
