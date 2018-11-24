import { Injectable } from '@angular/core';
import { Subject } from '../classes/subject';
import { Course } from '../classes/course';
import { User } from '../classes/user';

// majd az user kurzusait itt keressük meg
@Injectable({
  providedIn: 'root'
})
export class MyCoursesService {
    private dummySubject: Subject= { id: 2, name:"Anal6",courses:[
        {id:1, studentCount:0, studentLimit: 50} as Course,
        {id:2, studentCount:1, studentLimit: 50} as Course,
        {id:3, studentCount:2, studentLimit: 50} as Course
        ]
    } as Subject;
    private dummyTeacher: User = {name:"Tanar 1"} as User;
    private dummyStudent: User = {name:"Diak 1"} as User;
    private dummyStudent2: User = {name:"Diak 2"} as User;

  private _COURSES: Course[] = 
  [
        {id:1, studentCount:0, studentLimit: 50, subject:this.dummySubject,teacher:this.dummyTeacher,students:[this.dummyStudent,this.dummyStudent2]} as Course,
        {id:1, studentCount:5, studentLimit: 50, subject:this.dummySubject,teacher:this.dummyTeacher,students:[this.dummyStudent,this.dummyStudent2]} as Course,
        {id:1, studentCount:3, studentLimit: 50, subject:this.dummySubject,teacher:this.dummyTeacher,students:[this.dummyStudent,this.dummyStudent2]} as Course,
  ];

  constructor() { }

  public getCourses(): Course[] {
    return this._COURSES;
  }

  public getCourse(id: number): Course {
    return this._COURSES.find((course: Course) => course.id === id);
  }
}
