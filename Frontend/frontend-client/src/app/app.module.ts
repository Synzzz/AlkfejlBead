import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RoutingModule } from './routing/routing.module';
import { 
  MatToolbarModule, 
  MatButtonModule, 
  MatCardModule, 
  MatGridListModule, 
  MatListModule, 
  MatTableModule,
  MatExpansionModule,
  MatRadioModule,
  MatFormFieldModule,
  MatSelectModule,
  MatInputModule,
  MatAutocompleteModule

} from '@angular/material';

import { AppComponent } from './app.component';
import { SubjectListPageComponent } from './subject-list-page/subject-list-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MessageListPageComponent } from './message-list-page/message-list-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { CreateUserPageComponent } from './create-user-page/create-user-page.component';
import { NewMessagePageComponent } from './new-message-page/new-message-page.component';

@NgModule({
  declarations: [
    AppComponent,
    SubjectListPageComponent,
    NavbarComponent,
    MessageListPageComponent,
    LoginPageComponent,
    CreateUserPageComponent,
    NewMessagePageComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    RoutingModule,
    MatToolbarModule,
    MatRadioModule,
    MatExpansionModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatListModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatAutocompleteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
