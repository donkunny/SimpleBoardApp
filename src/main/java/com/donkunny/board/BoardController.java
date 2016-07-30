package com.donkunny.board;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.donkunny.logic.BoardVO;
import com.donkunny.service.BoardService;

@Controller
@SessionAttributes("boardVO")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value="/list")
	public String list(Model model){
		model.addAttribute("boardList", boardService.list());
		return "/list";
	}

	@RequestMapping(value="/read/{seq}")
	public String read(Model model, @PathVariable int seq){
		model.addAttribute("boardVO", boardService.read(seq));
		return "/read";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model){
		model.addAttribute("boardVO", new BoardVO());
		return "/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "/write";
		} else {
			boardService.write(boardVO);
			return "redirect:/list";
		}
	}
	
	@RequestMapping(value="/edit/{seq}", method=RequestMethod.GET)
	public String edit(@PathVariable int seq, Model model) {
		BoardVO boardVO = boardService.read(seq);
		model.addAttribute("boardVO", boardVO);
		return "/edit";
	}
	
	@RequestMapping(value="/edit/{seq}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute BoardVO boardVO, BindingResult bindingResult, int pwd, SessionStatus sessionStatus ,Model model){
		if(bindingResult.hasErrors()){
			return "/edit";
		}
		else {
			if(boardVO.getPassword() == pwd) {
				boardService.edit(boardVO);
				sessionStatus.setComplete();
				return "redirect:/list";
			}
			
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/edit";
		}
	}
	
	@RequestMapping(value="/delete/{seq}", method = RequestMethod.GET)
	public String delete(@PathVariable int seq, Model model){
		model.addAttribute("seq", seq);
		return "/delete";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(int seq, int pwd, Model model){
		int rowCount;
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(seq);
		boardVO.setPassword(pwd);
		
		rowCount = boardService.delete(boardVO);
		
		if(rowCount == 0){
			model.addAttribute("seq", seq);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/delete";
		} else {
			return "redirect:/list";
		}
	}
}
