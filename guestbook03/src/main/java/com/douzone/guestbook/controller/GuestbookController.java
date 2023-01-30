package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.guestbookRepository;
import com.douzone.guestbook.vo.guestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private guestbookRepository guestbookRepository = new guestbookRepository();
	
	@RequestMapping("/")
	public String index(Model model) {
		List<guestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list",list);
		return "/WEB-INF/views/index.jsp";
	}
	@RequestMapping("/add")
	public String add(guestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Model model,@RequestParam(value="no",required=false) Long no) {
		model.addAttribute("no",no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(guestbookVo vo) {
		guestbookRepository.delete(vo);
		return "redirect:/";
	}
}
