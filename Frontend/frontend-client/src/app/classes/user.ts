import { Course } from "./course";


export class User {
    public id: number;
    public username: string;
    public password: string;
    public name: string;
    public courses: Course[];
    public role: string;
    //password kell ide?
  }
  