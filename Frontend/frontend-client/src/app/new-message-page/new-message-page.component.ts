import { Component, OnInit } from '@angular/core';
import {FormControl,Validators,FormBuilder} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { MessageService } from '../services/message.service';
import { Message } from '../classes/message';
import { AuthService } from '../services/authentication.service';
import { User } from '../classes/user';

@Component({
  selector: 'app-new-message-page',
  templateUrl: './new-message-page.component.html',
  styleUrls: ['./new-message-page.component.css']
})
export class NewMessagePageComponent implements OnInit {
//igy valamiért ment, az előzők mintájára meg nem  ¯\_(ツ)_/¯
  private fb: FormBuilder
  private newMessageForm 

  constructor(fb: FormBuilder,
    private messageService : MessageService,
    private authService : AuthService) {
    this.newMessageForm = fb.group({
      'name': ['',Validators.required],
      'message':['',Validators.required]
    });
  }
  ///kopikód angular oldaláról
  name = new FormControl();

 ngOnInit() {
    
  }

  displayFn(user?: User): string | undefined {
    return user ? user.name : undefined;
  }
  
 
message: Message;

  private onSubmit() {
    //validalni a bejelentkezest majd valahogy
    if (this.newMessageForm.invalid) {
      return;
    }

    this.message = new Message();
    this.message.sender = this.authService.user;
    this.message.addressee = { id : 0, courses : undefined, name : undefined, password : undefined, role : undefined, username : this.newMessageForm.value.name }
    this.message.message = this.newMessageForm.value.message;

    this.messageService.sendMessage(this.message);
  }
}
