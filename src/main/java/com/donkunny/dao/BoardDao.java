package com.donkunny.dao;

import java.util.List;

import com.donkunny.logic.BoardVO;

public interface BoardDao {
	public abstract List<BoardVO> list();
	public abstract int delete(BoardVO boardVO);
	public  abstract int deleteAll();
	public abstract int update(BoardVO boardVO);
	public abstract void insert(BoardVO boardVO);
	public abstract BoardVO select(int seq);
	public abstract int updateReadCount(int seq);
}
