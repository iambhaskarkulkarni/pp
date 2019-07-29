import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../list-todos/list-todos.component';
import { TodoserviceService } from '../service/data/todoservice.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id:number
  todo: Todo

  constructor(
    private router : Router,
    private route : ActivatedRoute,
    private todoserviceService : TodoserviceService

  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'],
    this.todo = new Todo(this.id, '',new Date(),false)
    if(this.id != -1) {
      this.todoserviceService.retrieveTodo('bhaskar',this.id).subscribe(
        data => this.todo = data
      )
    }
  }

  saveTodo() {
    if(this.id == -1) {
      this.todoserviceService.createTodo('bhaskar',this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['todos'])
        }
      )
    } else {
      this.todoserviceService.updateTodo('bhaskar',this.id,this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['todos'])
        }
      )
    }
  }
}
