package com.kulkarni.pp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.kulkarni.pp.dto.TodoDTO;

@Service
public class TodoServiceImpi implements TodoService {
	
	public static final List<TodoDTO> dtos = new ArrayList<TodoDTO>();
	
	public static long idCounter = 0;
	
	static {
		dtos.add(new TodoDTO(++idCounter, "Learn to dance", new Date(), false));
		dtos.add(new TodoDTO(++idCounter, "I am Bhaskar Kulkarni", new Date(), false));
		dtos.add(new TodoDTO(++idCounter, "Learn to dance", new Date(), false));
		dtos.add(new TodoDTO(++idCounter, "Learn to dance", new Date(), false));
	}
	
	public TodoDTO getDtoById(long id) {
		for(TodoDTO dto : dtos) {
			if(dto.getId() == id) {
				return dto;
			}
		}
		return null;
	}
	
	public List<TodoDTO> listAllDTOs() {
		return dtos;
	}
	
	public TodoDTO deleteDTO(long id) {
		TodoDTO dto = getDtoById(id);
		if(dto == null) return null;
		if(dtos.remove(dto)) {
			return dto;
		}
		return null;
		
	}
	
	public TodoDTO saveOrUpdateDTO(TodoDTO dto) {
		if(dto.getId() != null) {
			TodoDTO dto2 = getDtoById(dto.getId());
			dto2.setDescription(dto.getDescription());
			dto2.setTargetDate(dto.getTargetDate());
			dto2.setDone(dto.isDone());
			return dto2;
		} else {
			TodoDTO todoDTO = new TodoDTO(++idCounter, dto.getDescription(), dto.getTargetDate(), false);
			dtos.add(todoDTO);
			return todoDTO;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
