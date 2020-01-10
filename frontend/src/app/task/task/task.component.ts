import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ITask } from 'src/app/types/task';
import { TaskService } from '../task.service';


@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent implements OnInit {
  
  emptyTask : ITask = {
    title : null,
    description : null,
    reporter : null,
    owner : null,
    status : null,
    deadline : null
  }
  
   task : ITask = {...this.emptyTask};
    
  constructor(private taskService: TaskService) {
    
  }

  ngOnInit() {
    
  }

  onSubmit(){
    this.taskService.postTask(this.task).subscribe(
      result => console.log("success", result),
      error => console.log("error", error)
    )
  }

}
