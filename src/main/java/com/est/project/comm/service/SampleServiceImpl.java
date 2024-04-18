package com.est.project.comm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.project.comm.domain.SampleDto;
import com.est.project.comm.mapper.SampleMapper;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class SampleServiceImpl implements SampleService {
	
	private final SampleMapper sampleMapper;

	
	@Override
	public List<SampleDto> selectMemList() {
	
		List<SampleDto> sampleDtos = sampleMapper.selectMemList();
		
		return sampleDtos;
	}

	
	@Override
	public void insertMbr(SampleDto sampleDto) {
		 sampleMapper.insertMbr(sampleDto);
	}
	
	
}
