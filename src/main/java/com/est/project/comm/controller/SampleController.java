package com.est.project.comm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.est.project.comm.domain.SampleDto;
import com.est.project.comm.service.SampleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SampleController {
	private final SampleService sampleService;
	
	@GetMapping("log")
	public String log() {
		return "common/log";
	}

	@GetMapping("regi")
	public String regi() {
		return "common/regi";
	}
	@GetMapping("memView")
	public String MemView(Model model) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@controlloer 시작");
		List<SampleDto> sampleDtos = sampleService.memView();
		model.addAttribute("memView", sampleDtos);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@controlloer 조ㅓㅇ료");
		return "common/memView";
	}
	
	
}
