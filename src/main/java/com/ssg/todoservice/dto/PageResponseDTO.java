package com.ssg.todoservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E>{
//    제너릭은 type의 확장성 때문에 사용함
//    list에 어떤 type의 데이터를 담을지 모르기 때문임
    private int page;
    private int size;
    private int total;

    private int start;
    private int end;

    private boolean prev;
    private boolean next;
    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page/10.0)) * 10 ;
        //페이지 끝 번호를 계산하는 수식
        //페이지가 1인 경우, 시작 페이지1 이며 마지막 페이지 10
        //페이지가 10인 경우, 시작 페이지 1이며, 마지막 페이지 20

        this.start = this.end - 9;

        int last = (int)(Math.ceil(this.total/(double)size));

        this.end = (end > last) ? last: end;

        this.prev = this.start > 1;

        this.next = total > this.end * this.size;

    }
}
