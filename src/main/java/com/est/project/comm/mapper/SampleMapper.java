package com.est.project.comm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.est.project.comm.domain.SampleDto;

@Mapper
public interface SampleMapper {
	
	List<SampleDto> selectMemList();
	void insertMbr(SampleDto sampleDto);
}
