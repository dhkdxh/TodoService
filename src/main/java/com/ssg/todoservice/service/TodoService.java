package com.ssg.todoservice.service;

import com.ssg.todoservice.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();

    TodoDTO getOne(int tno);

    void remove(int tno);

    void modify(TodoDTO todoDTO);
}
