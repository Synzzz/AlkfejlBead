import { Component, OnInit } from '@angular/core';
import { SubjectService } from '../services/subject.service';
import { Subject } from '../classes/subject';
import { MyCoursesService } from '../services/my-courses.service';
import { Course } from '../classes/course';
import { Router } from '@angular/router';


@Component({
  selector: 'app-subject-list-page',
  templateUrl: './subject-list-page.component.html',
  styleUrls: ['./subject-list-page.component.css']
})
export class SubjectListPageComponent implements OnInit {

  private _subjects: Subject[];
  private selectedCourses: { [subjectId : number] : number } = {};

  constructor(
    private _subjectService: SubjectService,
    private courseService : MyCoursesService,
    private router: Router

  ) { }

  async ngOnInit() {
    this._subjects = await this._subjectService.getSubjects();
    let takenCourses = await this.courseService.getCourses();

    for(let j = 0; j < takenCourses.length; j++) {
        let sub = await this.courseService.getCourseSubject(takenCourses[j].id);
        for(let i = 0; i < this._subjects.length; i++) {
          if(this._subjects[i].id == sub.id){
            this._subjects.splice(i, 1);
            i--;
          }
      }
    }

    for(let subject of this._subjects){
      for(let course of subject.courses){
        course.teacher = await this.courseService.getCourseTeacher(course.id);
      }
    }
  }

  setCourse(subjectId : number, courseId : number){
    this.selectedCourses[subjectId] = courseId;
  }

  register(){
    for(let subjectId in this.selectedCourses){
      let courseId = this.selectedCourses[subjectId]
      this.courseService.takeCourse(courseId);

    }
    this.router.navigate(['/my-courses']);

  }
}
