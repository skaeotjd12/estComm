package com.est.project.comm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.est.project.comm.domain.SampleDto;
import com.est.project.comm.dto.ResponseDto;
import com.est.project.comm.service.SampleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SampleApiController {
	
	private final SampleService sampleService;
	
	@PostMapping("/regi")
	public ResponseDto<?> ApiRegi(@RequestBody SampleDto sampleDto) {
		
		
		sampleService.insertMbr(sampleDto);
		System.out.println("실행됨@@@@@@@@@@@@@@@@@");
		System.out.println("dto " + sampleDto.getMbr_Id());
		
		
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
