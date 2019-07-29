import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Todo{
  id : number;
  description:string;
  public targetDate : Date;
  public done : boolean
}

@Injectable({
  providedIn: 'root'
})
export class TodoserviceService {

  constructor(private http : HttpClient) { }

  getAllTodos() {
    return this.http.get<Todo[]>('todos');
  }

  retrieveTodo(username,id){
    return this.http.get<Todo>(`todos/users/${username}/todos/${id}`)
  }

  updateTodo(username: string,id: number,todo){
    return this.http.put(`todos/users/${username}/todos/${id}`,todo)
  }

  createTodo(username,todo) {
    return this.http.post(`todos/users/${username}/todos`,todo)
  }

  deleteTodo(username,id) {
    return this.http.delete(`todos/users/${username}/todos/${id}`)
  }
  
  

}
