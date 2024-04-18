package com.est.project.comm.service;

import java.util.List;

import com.est.project.comm.domain.SampleDto;


public interface SampleService {
	
	public List<SampleDto> selectMemList();
	public void  insertMbr(SampleDto sampleDto);
}
