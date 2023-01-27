package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping 클래스 단독 매핑
 * Spring mvc 4.x 에서만 지원!!!
 * 내부 list,delete 함수들 mapping에 ("list") , ("delete") 해서 매핑해주면 5.x에서 돌아가긴 함
 */
//@Controller
@RequestMapping("/guestbook/*")
public class GuestBookController {

	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController.list()";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController.delete()";
	}
}
