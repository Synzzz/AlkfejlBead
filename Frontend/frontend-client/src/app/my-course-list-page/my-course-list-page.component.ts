import { Component, OnInit } from '@angular/core';
import { MyCoursesService } from '../services/my-courses.service';
import { Course } from '../classes/course';
import { Router } from '@angular/router';


@Component({
  selector: 'app-my-course-list-page',
  templateUrl: './my-course-list-page.component.html',
  styleUrls: ['./my-course-list-page.component.css']
})
export class MyCourseListPageComponent implements OnInit {
  private _courses: Course[];
  

  constructor(
    private _myCoursesService: MyCoursesService,
    private router: Router


  ) { }

  async ngOnInit() {
    this._courses = await this._myCoursesService.getCourses();

    for(let course of this._courses){
      course.teacher = await this._myCoursesService.getCourseTeacher(course.id);
      course.students = await this._myCoursesService.getCourseStudents(course.id);
      course.subject = await this._myCoursesService.getCourseSubject(course.id);
    }
  }

  leaveCourse(courseId : number){
    this._myCoursesService.leaveCourse(courseId);
    this.router.navigate(['/my-courses']);

  }
}