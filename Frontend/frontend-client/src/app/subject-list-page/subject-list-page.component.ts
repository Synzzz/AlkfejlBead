import { Component, OnInit } from '@angular/core';
import { SubjectService } from '../services/subject.service';
import { Subject } from '../classes/subject';

@Component({
  selector: 'app-subject-list-page',
  templateUrl: './subject-list-page.component.html',
  styleUrls: ['./subject-list-page.component.css']
})
export class SubjectListPageComponent implements OnInit {

  private _subjects: Subject[];

  constructor(
    private _subjectService: SubjectService

  ) { }

  ngOnInit() {
    this._subjects = this._subjectService.getSubjects();

  }

}
