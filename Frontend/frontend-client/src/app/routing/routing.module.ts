import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Route } from '@angular/router';
import { SubjectListPageComponent } from '../subject-list-page/subject-list-page.component';
import { MessageListPageComponent } from '../message-list-page/message-list-page.component';

const routes: Route[] = [
  { path: '', component: SubjectListPageComponent },
  { path: 'my-messages', component: MessageListPageComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }
