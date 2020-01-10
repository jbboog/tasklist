import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { ITask }  from '../types/task';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class TaskService {

  private taskUrl : string;

  
  constructor(private http : HttpClient) {
    this.taskUrl = "http://localhost:8080/task";
   }

   public postTask(task : ITask) : Observable<any>{
    //return of(task);
    return this.http.post(this.taskUrl,task);
   }
}
