package com.est.project.contents.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.est.project.contents.domain.Board;



@Mapper
public interface ContentsMapper {
	
	
	List<Board> selectBoardList(Map<String, Object> map);
	Integer selectPagingCount(Map<String, Object> map);
	
}
