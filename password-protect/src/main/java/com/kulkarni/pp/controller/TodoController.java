package com.kulkarni.pp.controller;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kulkarni.pp.dto.TodoDTO;
import com.kulkarni.pp.service.TodoService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController {
	
	@Autowired
	@Qualifier(value="TodoJpaService")
	TodoService todoService;
	
	@GetMapping("/todos")
	public List<TodoDTO> getAllDTOs() {
		return todoService.listAllDTOs();
	}

	@GetMapping("/todos/{id}")
	public TodoDTO getTodoById(@PathVariable long id) {
		return todoService.getDtoById(id);
	}
	
	@DeleteMapping("todos/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		TodoDTO dto = todoService.deleteDTO(id);
		if(dto != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("todos/users/{username}/todos/{id}")
	public ResponseEntity<TodoDTO> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody TodoDTO todo) {
		TodoDTO updatedTodo = todoService.saveOrUpdateDTO(todo);
		return new ResponseEntity<TodoDTO>(todo, HttpStatus.OK);
	}
	
	@PostMapping("todos/users/{username}/todos")
	public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody TodoDTO todo) {
		todo.setId(null);
		TodoDTO createdTod = todoService.saveOrUpdateDTO(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTod.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
	
	
	
	
	
	
	
}
