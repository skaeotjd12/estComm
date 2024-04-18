package com.est.project.contents.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.est.project.contents.domain.Board;
import com.est.project.contents.mapper.ContentsMapper;
import com.est.project.contents.service.ContentsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContentsController {

	private final ContentsService contentsService;
	private final ContentsMapper contentsMapper;
	
	//test
	@GetMapping("/board")
	public String board() {
		
		List<Board> list = contentsMapper.test();
		System.out.println(list);
		return "contents/board";
	}
}
