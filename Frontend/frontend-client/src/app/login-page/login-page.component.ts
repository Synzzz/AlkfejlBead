import { Component, OnInit } from '@angular/core';
import { FormBuilder,Validators } from '@angular/forms';
import { User } from '../classes/user';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  private loginForm = this.fb.group({
    username: ['',Validators.required],
    password: ['',Validators.required],   
  });

  constructor(
    private fb: FormBuilder

  ) { }

  ngOnInit() {
  }

  private onSubmit() {
    //validalni a bejelentkezest majd valahogy

  }

}
