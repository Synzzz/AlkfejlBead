import { Component, OnInit } from '@angular/core';
import { MyCoursesService } from '../services/my-courses.service';
import { Course } from '../classes/course';

@Component({
  selector: 'app-my-course-list-page',
  templateUrl: './my-course-list-page.component.html',
  styleUrls: ['./my-course-list-page.component.css']
})
export class MyCourseListPageComponent implements OnInit {


  private _courses: Course[];
  

  constructor(
    private _myCoursesService: MyCoursesService

  ) { }

  ngOnInit() {
    this._courses = this._myCoursesService.getCourses();

  }

}