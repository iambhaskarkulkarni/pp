package com.kulkarni.pp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kulkarni.pp.dao.TodoRepository;
import com.kulkarni.pp.dto.TodoDTO;
import com.kulkarni.pp.entity.Todo;

@Service(value="TodoJpaService")
public class TodoJpaService implements TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public TodoDTO copyModelToDTO(Todo todo) {
		return new TodoDTO(todo.getId(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
	}

	@Override
	public TodoDTO getDtoById(long id) {
		Todo todo = todoRepository.findById(id).get();
		return copyModelToDTO(todo);
	}

	@Override
	public List<TodoDTO> listAllDTOs() {
		List<Todo> todos = todoRepository.findAll();
		List<TodoDTO> dtos = new ArrayList<>();
		todos.forEach(todo -> dtos.add(copyModelToDTO(todo)));
		return dtos;
	}

	@Override
	public TodoDTO deleteDTO(long id) {
		Todo todo = todoRepository.findById(id).get();
		todoRepository.delete(todo);
		return copyModelToDTO(todo);
	}

	@Override
	public TodoDTO saveOrUpdateDTO(TodoDTO dto) {
		Todo todo = new Todo(dto.getId(), dto.getDescription(), dto.getTargetDate(), dto.isDone());
		todo = todoRepository.save(todo);
		return copyModelToDTO(todo);
	}

}
