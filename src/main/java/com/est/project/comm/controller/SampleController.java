package com.est.project.comm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.est.project.comm.domain.SampleDto;
import com.est.project.comm.dto.ResponseDto;
import com.est.project.comm.service.SampleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SampleController {
	private final SampleService sampleService;
	
	//로그인 페이지 
	@GetMapping("log")
	public String log() {
		return "common/log";
	}
	
	//회원 조회
	@GetMapping("memView")
	public String selectMemList(Model model) {
		List<SampleDto> sampleDtos = sampleService.selectMemList();
		model.addAttribute("memView", sampleDtos);
		return "common/memView";
	}
	
	@GetMapping("regi")
	public String regi() {
		return "common/regi";
	}
}
