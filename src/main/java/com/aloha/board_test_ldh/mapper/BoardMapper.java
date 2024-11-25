package com.aloha.board_test_ldh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.board_test_ldh.dto.Board;
import com.aloha.board_test_ldh.dto.Page;

@Mapper
public interface BoardMapper {

    int count();
    // 게시글 목록
    public List<Board> list() throws Exception;
    // 게시글 조회
    public Board select(String id) throws Exception;
    // 게시글 등록
    public int insert(Board board) throws Exception;
    // 게시글 수정
    public int update(Board board) throws Exception;
    // 게시글 삭제
    public int delete(String id) throws Exception;

    public List<Board> list(@Param("page") Page page) throws Exception;
}
