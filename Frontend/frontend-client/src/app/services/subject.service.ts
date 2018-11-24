import { Injectable } from '@angular/core';
import { Subject } from '../classes/subject';
import { Course } from '../classes/course';
import { User } from '../classes/user';


@Injectable({
  providedIn: 'root'
})
export class SubjectService {
  private dummyTeacher: User = {name:"Tanar 1"} as User;

  private _SUBJECTS: Subject[] = 
  [
    { id: 1, name:"Anal5",courses:[
        {id:1, studentCount:0, studentLimit: 50,teacher:this.dummyTeacher} as Course,
        {id:2, studentCount:1, studentLimit: 50,teacher:this.dummyTeacher} as Course,
        {id:3, studentCount:2, studentLimit: 50,teacher:this.dummyTeacher} as Course
        ]
    } as Subject,
    { id: 2, name:"Anal6",courses:[
        {id:1, studentCount:0, studentLimit: 50,teacher:this.dummyTeacher} as Course
        ]
    } as Subject,
    { id: 3, name:"Anal7",courses:[
        {id:1, studentCount:0, studentLimit: 50,teacher:this.dummyTeacher} as Course
        ]
    } as Subject,
    { id: 4, name:"Anal8",courses:[
        {id:1, studentCount:0, studentLimit: 50,teacher:this.dummyTeacher} as Course
        ]
    } as Subject,
  ];

  constructor() { }

  public getSubjects(): Subject[] {
    return this._SUBJECTS;
  }

  public getSubject(id: number): Subject {
    return this._SUBJECTS.find((subject: Subject) => subject.id === id);
    // return this._MACHINES.find(function (machine) {
    //   return machine.id === id;
    // })
  }
}
