import { Component, OnInit } from '@angular/core';
import {FormControl,Validators,FormBuilder} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
//import { User } from '../classes/user';

//ideiglenes, majd apibol jon normalis user
export interface User {
  name: string;
}

@Component({
  selector: 'app-new-message-page',
  templateUrl: './new-message-page.component.html',
  styleUrls: ['./new-message-page.component.css']
})
export class NewMessagePageComponent implements OnInit {
//igy valamiért ment, az előzők mintájára meg nem  ¯\_(ツ)_/¯
  private fb: FormBuilder
  private newMessageForm 

  constructor(fb: FormBuilder) {
    this.newMessageForm = fb.group({
      'name': ['',Validators.required],
      'message':['',Validators.required]
    });
  }
  ///kopikód angular oldaláról
  name = new FormControl();
  options: User[] = [
    {name: 'Mary'},
    {name: 'Shelley'},
    {name: 'Béla'},
    {name: 'Igor'}
  ];
  filteredOptions: Observable<User[]>;

 ngOnInit() {
    this.filteredOptions = this.name.valueChanges
      .pipe(
        startWith<string | User>(''),
        map(value => typeof value === 'string' ? value : value.name),
        map(name => name ? this._filter(name) : this.options.slice())
      );
  }

  displayFn(user?: User): string | undefined {
    return user ? user.name : undefined;
  }

  private _filter(name: string): User[] {
    const filterValue = name.toLowerCase();

    return this.options.filter(option => option.name.toLowerCase().indexOf(filterValue) === 0);
  }
  
 


  private onSubmit() {
    //validalni a bejelentkezest majd valahogy
    console.log(this.newMessageForm.value.name.name)
  }
}
