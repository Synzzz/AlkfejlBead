import { Subject } from "./subject";
import { User } from "./user";


export class Course {
    public id: number;
    public studentCount: number;
    public studentLimit: number;
    public students: User[];
    public subject: Subject;
    public teacher: User;


  }
  