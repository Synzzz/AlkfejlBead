import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';
import { User } from '../classes/user';
import { HttpService } from '../services/http.service';

@Component({
  selector: 'app-create-user-page',
  templateUrl: './create-user-page.component.html',
  styleUrls: ['./create-user-page.component.css']
})
export class CreateUserPageComponent implements OnInit {
  @Output('user') public user: EventEmitter<User> 
    = new EventEmitter<User>();

  private _user: User = {
    id: null,
    username: null,
    password: null,
    name: null,
    courses: null,
    role: null
  }

  private createUserForm = this.fb.group({
    name: [''],
    username: [''],
    password: [''],
    role: [''],
  });

  constructor(
    private fb: FormBuilder,
    private httpService : HttpService

  ) { }

  ngOnInit() {
  }

  private onSubmit() {
    if (this.createUserForm.invalid) {
      return;
    }
    this._user.name=this.createUserForm.get('name').value;
    this._user.username=this.createUserForm.get('username').value;
    this._user.password=this.createUserForm.get('password').value;
    this._user.role=this.createUserForm.get('role').value;

    this.user.emit(this._user);
    //teszt, majd kitorolni
    //console.log(this._user);

    this.httpService.post('users/register', this._user);
  }

}
