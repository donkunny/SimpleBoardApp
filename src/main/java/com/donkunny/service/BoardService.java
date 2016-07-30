package com.donkunny.service;

import java.util.List;

import com.donkunny.logic.BoardVO;

public interface BoardService {
	public abstract List<BoardVO> list();
	public abstract int delete(BoardVO boardVO);
	public abstract int edit(BoardVO boardVO);
	public abstract void write(BoardVO boardVo);
	public abstract BoardVO read(int seq);
}
