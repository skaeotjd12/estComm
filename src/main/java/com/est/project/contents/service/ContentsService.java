package com.est.project.contents.service;

import java.util.List;

import com.est.project.contents.domain.Board;

public interface ContentsService {

	List<Board> getBoardList(String category, String detailCategory);

}
