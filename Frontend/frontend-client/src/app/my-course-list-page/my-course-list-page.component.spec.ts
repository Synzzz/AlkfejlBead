import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyCourseListPageComponent } from './my-course-list-page.component';

describe('MyCourseListPageComponent', () => {
  let component: MyCourseListPageComponent;
  let fixture: ComponentFixture<MyCourseListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyCourseListPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyCourseListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
