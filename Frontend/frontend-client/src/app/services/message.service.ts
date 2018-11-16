import { Injectable } from '@angular/core';
import { Message } from '../classes/message';
import { User } from '../classes/user';


@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private _MESSAGES: Message[] = 
  [
    {id:1,message:"Hallohallo",sender:{name:"Bela"}as User,recipient:{name:"Bela"}as User},
  ];

  constructor() { }

  public getMessages(): Message[] {
    return this._MESSAGES;
  }

  public getMessage(id: number): Message {
    return this._MESSAGES.find((message: Message) => message.id === id);
    // return this._MACHINES.find(function (machine) {
    //   return machine.id === id;
    // })
  }
}
