package com.kulkarni.pp.service;

import java.util.List;

import com.kulkarni.pp.dto.TodoDTO;

public interface TodoService {

	public TodoDTO getDtoById(long id);
	
	public List<TodoDTO> listAllDTOs();
	
	public TodoDTO deleteDTO(long id);
	
	public TodoDTO saveOrUpdateDTO(TodoDTO dto);
}
