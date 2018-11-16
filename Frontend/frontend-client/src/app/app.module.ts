import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RoutingModule } from './routing/routing.module';
import { MatToolbarModule, MatButtonModule, MatCardModule, MatGridListModule, MatListModule, MatTableModule,MatExpansionModule,MatRadioModule} from '@angular/material';

import { AppComponent } from './app.component';
import { SubjectListPageComponent } from './subject-list-page/subject-list-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MessageListPageComponent } from './message-list-page/message-list-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { CreateUserPageComponent } from './create-user-page/create-user-page.component';

@NgModule({
  declarations: [
    AppComponent,
    SubjectListPageComponent,
    NavbarComponent,
    MessageListPageComponent,
    LoginPageComponent,
    CreateUserPageComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RoutingModule,
    MatToolbarModule,
    MatRadioModule,
    MatExpansionModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatListModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
