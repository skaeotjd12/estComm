package com.est.project.contents.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.est.project.contents.domain.Board;
import com.est.project.contents.domain.PageResponse;
import com.est.project.contents.mapper.ContentsMapper;
import com.est.project.contents.service.ContentsService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContentsController {

	private final ContentsService contentsService;
	
	
	@GetMapping("/board")
	@ResponseBody
	public PageResponse<Board> getBoardList(@RequestParam(required = true) String category,
						@RequestParam(required = false) String detailCategory,
						@RequestParam(defaultValue = "1" , name = "page") Integer page,
                        @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize) {
		 
		PageResponse<Board> pageResponse = contentsService.getBoardList(category, detailCategory, page, pageSize);
		return pageResponse;
	}
}
