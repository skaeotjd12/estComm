package com.est.project.contents.domain;

import java.util.List;
import java.util.stream.IntStream;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PageResponse<E> {

	private List<E> dtoList;
	private List<Integer> pageNumList;
	private PageRequest pageRequest;
	private Integer naviSize;
    private boolean prev, next;
    private Integer totalCount, prevPage, nextPage, totalPage, current;
	
    public PageResponse(List<E> dtoList, PageRequest pageRequest, int totalCount) {
        this.dtoList = dtoList;
        this.pageRequest = pageRequest;
        this.totalCount = totalCount;

        
        naviSize = pageRequest.getPageSize();

        
        totalPage = (int) Math.ceil(totalCount / (double) naviSize);

        
        current = pageRequest.getPage();

        
        Integer start = (pageRequest.getPage()-1) / naviSize * naviSize +1;

        
        Integer end = Math.min(start + naviSize -1, totalPage);

        
        pageNumList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

        
        prev = current > 1;

        
        next = current < totalPage;

        
        prevPage = prev ? current - 1 : 0;

       
        nextPage = next ? current + 1 : 0;
    }
}
