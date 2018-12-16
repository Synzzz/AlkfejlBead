import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Route } from '@angular/router';
import { SubjectListPageComponent } from '../subject-list-page/subject-list-page.component';
import { MessageListPageComponent } from '../message-list-page/message-list-page.component';
import { CreateUserPageComponent } from '../create-user-page/create-user-page.component';
import { LoginPageComponent } from '../login-page/login-page.component';
import { NewMessagePageComponent } from '../new-message-page/new-message-page.component';
import { MyCourseListPageComponent } from '../my-course-list-page/my-course-list-page.component';
import { AuthGuard } from '../auth.guard';

const routes: Route[] = [
  { path: '', component: SubjectListPageComponent, canActivate : [AuthGuard] },
  { path: 'my-messages', component: MessageListPageComponent, canActivate : [AuthGuard] },
  { path: 'create-user', component: CreateUserPageComponent, canActivate : [AuthGuard] },
  { path: 'login', component: LoginPageComponent },
  { path: 'new-message', component: NewMessagePageComponent, canActivate : [AuthGuard] },
  { path: 'my-courses', component: MyCourseListPageComponent, canActivate : [AuthGuard] },

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
