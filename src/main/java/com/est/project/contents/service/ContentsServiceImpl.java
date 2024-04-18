package com.est.project.contents.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.est.project.contents.domain.Board;
import com.est.project.contents.mapper.ContentsMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentsServiceImpl implements ContentsService{
	private final ContentsMapper contentsMapper;
	
	@Override
	public List<Board> getBoardList(String category, String detailCategory) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);
		map.put("detailCategory", detailCategory);
		
		List<Board> list = contentsMapper.selectBoardList(map);
		
		return list;
	}

	
}
