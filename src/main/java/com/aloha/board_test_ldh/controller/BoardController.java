package com.aloha.board_test_ldh.controller;

import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.aloha.board_test_ldh.dto.Board;
import com.aloha.board_test_ldh.dto.Page;
import com.aloha.board_test_ldh.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
  
  @Autowired
  private BoardService boardService;

  // 목록
  @GetMapping("/list")
  public String list(Model model
                          , Page page
                    ) throws Exception {
    List<Board> boardList = boardService.list();
    model.addAttribute("boardList", boardList);
    // model.addAttribute("rows", page.getRows());
    // model.addAttribute("page", page);

    // String pageUrl = UriComponentsBuilder.fromPath("/board/list")
    //                     // .queryParam("page", page.getPage())
    //                     .queryParam("rows", page.getRows())
    //                     .build()
    //                     .toUriString();

    // model.addAttribute("pageUrl", pageUrl);

    return "/board/list";
  }
  // 조회
  @GetMapping("/read")
  public String select(Model model, @RequestParam("id") String id) throws Exception {

      // 게시글 조회
      Board board = boardService.select(id);
      model.addAttribute("board", board);

      return "/board/read";

  }
  // 등록
  @GetMapping("/insert")
  public String insert() {
      return "/board/insert";
  }

  // 등록 처리
  @PostMapping("/insert")
  public String insertPost(Board board) throws Exception {
    log.info("board " + board);
      int result = boardService.insert(board);
      if ( result > 0 ) {
           return "redirect:/board/list";
      }
      return "redirect:/board/insert?error";
  }
  // 수정
  @GetMapping("/update")
  public String update(Model Model
                      ,@RequestParam("id") String id
                      ,Model model) throws Exception {
      // 게시글 조회
      Board board = boardService.select(id);
      model.addAttribute("board", board);
      return "/board/update";
  }

  @PostMapping("/update")
  public String updatePost(Board board) throws Exception {
      int result = boardService.update(board);
      if ( result > 0 ) {
        return "redirect:/board/list";
      }
      return "redirect:/board/update?error&id="+board.getId();
  }
  // 삭제
  @PostMapping("/delete")
  public String delete(@RequestParam("id") String id) throws Exception {
    int result = boardService.delete(id);
    if ( result > 0 )
      return "redirect:/board/list";
    return "redirect:/board/update?error&id="+id;
  }
}
