import { Injectable } from '@angular/core';
import { Subject } from '../classes/subject';
import { Course } from '../classes/course';
import { User } from '../classes/user';
import { AuthService } from './authentication.service';
import { HttpService } from './http.service';

// majd az user kurzusait itt keressük meg
@Injectable({
  providedIn: 'root'
})
export class MyCoursesService {
  private route = 'courses';

  constructor(
    private httpService: HttpService,
    private authService : AuthService
  ) { }

  public getCourses(): Promise<Course[]> {
    return this.httpService.get('users/' + this.authService.user.id + '/courses');
  }
}
