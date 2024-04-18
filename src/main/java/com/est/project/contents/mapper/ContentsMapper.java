package com.est.project.contents.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.est.project.contents.domain.Board;



@Mapper
public interface ContentsMapper {
	List<Board> test();
}
