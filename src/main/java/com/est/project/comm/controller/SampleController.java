package com.est.project.comm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	
	
	@GetMapping("log")
	public String log() {
		return "common/log";
	}

	@GetMapping("regi")
	public String regi() {
		return "common/regi";
	}
	
	
}
