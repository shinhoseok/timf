package com.teamf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VocController {
	@RequestMapping("/voc/selectVocList")
	public String selectVocList() throws Exception {
		System.out.println("shin>>>");
		return "/voc/vocList";
	}
}
