package com.aloha.board_test_ldh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.board_test_ldh.dto.Board;
import com.aloha.board_test_ldh.dto.Page;
import com.aloha.board_test_ldh.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> list() throws Exception {
        List<Board> List = boardMapper.list();
        return List;
    }

    @Override
    public Board select(String id) throws Exception {
        Board board = boardMapper.select(id);
        return board;        
    }

    
    @Override
    public int insert(Board board) throws Exception {
        int result = boardMapper.insert(board);
        return result;
    }
  
    
    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);
        return result;
    }

    @Override
    public int delete(String id) throws Exception {
        int result = boardMapper.delete(id);
        return result;
    }

    @Override
    public List<Board> list(Page page) throws Exception {
        // 데이터 개수
        int total = boardMapper.count();
        page.setTotal(total);
        List<Board> boardList = boardMapper.list(page);
        return boardList;
    }

}
