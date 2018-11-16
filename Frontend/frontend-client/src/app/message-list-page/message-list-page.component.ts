import { Component, OnInit } from '@angular/core';
import { MessageService } from '../services/message.service';
import { Message } from '../classes/message';

@Component({
  selector: 'app-message-list-page',
  templateUrl: './message-list-page.component.html',
  styleUrls: ['./message-list-page.component.css']
})
export class MessageListPageComponent implements OnInit {

  private _messages: Message[];

  constructor(
    private _messageService: MessageService

  ) { }

  ngOnInit() {
    this._messages = this._messageService.getMessages();

  }

}
