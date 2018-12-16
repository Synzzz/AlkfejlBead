import { Injectable } from '@angular/core';
import { Subject } from '../classes/subject';
import { Course } from '../classes/course';
import { User } from '../classes/user';
import { HttpService } from './http.service';
import { AuthService } from './authentication.service';


@Injectable({
  providedIn: 'root'
})
export class SubjectService {
  private route = 'subjects';

  constructor(
    private httpService: HttpService,
    private authService : AuthService
  ) { }

  public getSubjects(): Promise<Subject[]> {
    return this.httpService.get(this.route);
  }
}
