import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomebbbComponent } from './homebbb.component';

describe('HomebbbComponent', () => {
  let component: HomebbbComponent;
  let fixture: ComponentFixture<HomebbbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomebbbComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomebbbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
