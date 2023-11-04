import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumbbComponent } from './forumbb.component';

describe('ForumbbComponent', () => {
  let component: ForumbbComponent;
  let fixture: ComponentFixture<ForumbbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ForumbbComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ForumbbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
