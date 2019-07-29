import { Component, OnInit } from '@angular/core';
import { TodoserviceService } from '../service/data/todoservice.service';
import { Router } from '@angular/router';

export class Todo {

   constructor(
     public id : Number,
     public description : string,
     public targetDate : Date,
     public done : boolean
   ){

   }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos:Todo[]

  constructor(private todoserviceService : TodoserviceService,
    private router : Router
    
    ) { }

  ngOnInit() {
    this.refreshTodos()
  }

  updateTodo(id) {
    console.log(`update ${id}`)
    this.router.navigate(['todos',id])
  }

  deleteTodo(id) {
      this.todoserviceService.deleteTodo('bhaskar',id).subscribe(
        response => {
          console.log(response)
          this.refreshTodos()
        }, error => {
          console.log(error)
        }
      )
  }

  refreshTodos() {
    this.todoserviceService.getAllTodos().subscribe(
      response => {
        console.log(response)
        this.todos = response;  
      }, error => {
        console.log(error)
      }

    )
  }

  addTodo() {
    this.router.navigate(['todos',-1])
  }

}
