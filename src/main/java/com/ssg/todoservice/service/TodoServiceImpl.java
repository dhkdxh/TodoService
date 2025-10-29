package com.ssg.todoservice.service;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        log.info(todoVO);

        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> list = todoMapper.selectAll().stream().map(
                i -> modelMapper.map(i, TodoDTO.class)
        ).collect(Collectors.toList());

        return list;
    }

    @Override
    public TodoDTO getOne(int tno) {
        TodoDTO dto = modelMapper.map(todoMapper.selectOne(tno), TodoDTO.class);

        return dto;
    }

    @Override
    public void remove(int tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        todoMapper.update(modelMapper.map(todoDTO, TodoVO.class));
    }
}
