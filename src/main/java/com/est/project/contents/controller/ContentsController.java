package com.est.project.contents.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.est.project.contents.domain.Board;
import com.est.project.contents.mapper.ContentsMapper;
import com.est.project.contents.service.ContentsService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContentsController {

	private final ContentsService contentsService;
	
	
	@GetMapping("/board")
	public String getBoardList(@RequestParam(required = true) String category,
						@RequestParam(required = false) String detailCategory) {
		
		List<Board> list = contentsService.getBoardList(category, detailCategory);
		System.out.println(list);
		return "contents/board";
	}
}
