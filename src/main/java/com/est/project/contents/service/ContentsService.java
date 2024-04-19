package com.est.project.contents.service;



import com.est.project.contents.domain.Board;
import com.est.project.contents.domain.PageResponse;

public interface ContentsService {

	PageResponse<Board> getBoardList(String category, String detailCategory, Integer page, Integer pageSize, String sorting);

}
