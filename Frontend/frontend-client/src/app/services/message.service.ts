import { Injectable } from '@angular/core';
import { Message } from '../classes/message';
import { User } from '../classes/user';
import { HttpService } from './http.service';
import { AuthService } from './authentication.service';


@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private route = 'messages';

  constructor(
    private httpService: HttpService,
    private authService : AuthService
  ) { }

  public getMessages(): Promise<Message[]> {
    return this.httpService.get(this.route + '/' + this.authService.user.id + '/addressee');
  }

  public sendMessage(message : Message) :void{
    this.httpService.post(this.route + '/sendMessage', message);
  }

  // public getMessage(id: number): Message {
  //   return this._MESSAGES.find((message: Message) => message.id === id);
  //   // return this._MACHINES.find(function (machine) {
  //   //   return machine.id === id;
  //   // })
  // }
}
