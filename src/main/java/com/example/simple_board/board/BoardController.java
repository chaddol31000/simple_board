package com.example.simple_board.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class BoardController {
  @Autowired
  private BoardService boardService;

  @GetMapping("/board/write")
  public ModelAndView write() {
    return new ModelAndView("board/write");
  }

  @PostMapping("/board/write")
  public ModelAndView write(Board board) {
    int bno = boardService.save(board);
    return new ModelAndView("redirect/board/read?bno=" + bno);
  }

  @GetMapping("/")
  public ModelAndView list() {
    List<Board> boards = boardService.findAll();
    return new ModelAndView("board/list").addObject("boards", boards);
  }

  @GetMapping("/board/read")
  public ModelAndView findByBno(int bno) {
    Board board = boardService.findByBno(bno);
    return new ModelAndView("board/read").addObject("board", board);
  }

  @PostMapping("/board/update")
  public ModelAndView update(Board board) {
    boolean result = boardService.update(board);
    if (result)
      return new ModelAndView("redirect:/board/read?bno=" + board.getBno());
    return new ModelAndView("redirect:/");
  }

  @PostMapping("board/delete")
  public ModelAndView delete(Integer bno, String password) {
    boardService.delete(bno, password);
    return new ModelAndView("redirect:/");
  }
}
