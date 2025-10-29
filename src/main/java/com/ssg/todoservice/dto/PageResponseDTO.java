package com.ssg.todoservice.dto;

import lombok.Builder;

import java.util.List;

public class PageResponseDTO<E>{

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO() {

    }
    private int page;
    private int size;
    private int total;

    private int start;
    private int end;

    private boolean prev;
    private boolean next;
    private List<E> dtoList;
}
