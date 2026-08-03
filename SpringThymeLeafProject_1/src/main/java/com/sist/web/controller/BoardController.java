package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.service.*;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
@RequestMapping("board/")
public class BoardController {
   private final BoardService bService;
   
   @GetMapping("list")
   public String board_list(
		   @RequestParam(value = "page",required = false) String page, Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int start=(curpage*10)-10;
	   List<BoardEntity> list=bService.boardListData(start);
	   int count=bService.boardCount();
	   int totalpage=(int)(Math.ceil(count/10.0));
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "board/list";
   }
   @GetMapping("detail")
   public String board_detail(@RequestParam("no") int no,
		   Model model)
   {
	   BoardEntity vo=bService.findByNo(no);
	   vo.setHit(vo.getHit()+1);
	   bService.boardUpdate(vo);
	   
	   vo=bService.findByNo(no);
	   model.addAttribute("vo", vo);
	   return "board/detail";
   }
   @GetMapping("insert")
   public String board_insert()
   {
	   return "board/insert";
   }
   @PostMapping("insert_ok")

   public String board_insert_ok(@ModelAttribute("vo") BoardEntity vo)
   {
	   bService.boardInsert(vo);
	   return "redirect:/board/list";
   }
}