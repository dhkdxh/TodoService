package com.ssg.todoservice.service;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.PageResponseDTO;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

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
    public List<TodoDTO> getAll(PageRequestDTO pageRequestDTO) {
        List<TodoDTO> list = todoMapper.selectAll(pageRequestDTO).stream().map(
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

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectAll(pageRequestDTO);

        List<TodoDTO> dtoList = voList.stream().map(
                i -> modelMapper.map(i, TodoDTO.class)
        ).collect(Collectors.toList());

        int total = todoMapper.getCount(pageRequestDTO);

        //생성자 호출하는 방법
        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                        .dtoList(dtoList).total(total).pageRequestDTO(pageRequestDTO).build();

        return pageResponseDTO;
    }
}
