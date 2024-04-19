package com.est.project.contents.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.est.project.contents.domain.Board;
import com.est.project.contents.domain.PageRequest;
import com.est.project.contents.domain.PageResponse;
import com.est.project.contents.mapper.ContentsMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentsServiceImpl implements ContentsService{
	private final ContentsMapper contentsMapper;
	
	@Override
	public PageResponse<Board> getBoardList(String category, String detailCategory, Integer page, Integer pageSize) {
		PageRequest pageRequest = new PageRequest(page, pageSize);
		
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);
		map.put("detailCategory", detailCategory);
		map.put("offset", pageRequest.getOffset());
		map.put("limit", pageRequest.getPageSize());
		
		List<Board> list = contentsMapper.selectBoardList(map);
		Integer count = contentsMapper.selectPagingCount(map);
		PageResponse<Board> pageResponse = new PageResponse<>(list, pageRequest, count);
		return pageResponse;
	}

	
}
