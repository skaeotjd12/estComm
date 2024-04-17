package com.est.project.comm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.project.comm.domain.SampleDto;
import com.est.project.comm.mapper.SampleMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
	
	private final SampleMapper sampleMapper;
	private final SampleService sampleService;
	
	@Override
	public List<SampleDto> memView() {
		List<SampleDto> sampleDtos = sampleMapper.selectMemList();
		return sampleDtos;
	}
	
	
}
