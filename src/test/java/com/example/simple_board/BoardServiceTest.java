package com.example.simple_board;

import com.example.simple_board.board.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardServiceTest {
  @Autowired
  private BoardService boardService;

  @Test
  public void initTest() {
     assertNotNull(boardService);
  }

  @Test
  public void saveTest() {
    Board board = Board.builder().title("연습").content("연습 내용").nickname("spring").password("1234").build();
    int bno = boardService.save(board);
    assertEquals(true, bno>0);
  }

  @Test
  public void findAllTest() {
    assertEquals(true, boardService.findAll().size()>0);
  }

  @Transactional
  @Test
  public void findByBnoTest(){
    Board board = boardService.findByBno(2);
    assertEquals(2, board.getBno());
  }

  @Transactional
  @Test
  public void update실패Test() {
    Board board = Board.builder().bno(2).title("변경").content("변경 내용").password("1111").build();
    assertEquals(false, boardService.update(board));
  }

  @Transactional
  @Test
  public void update성공Test() {
    Board board = Board.builder().bno(2).title("변경").content("변경11").password("1234").build();
    assertEquals(true, boardService.update(board));
  }

  @Transactional
  @Test
  public void delete실패Test() {
    assertEquals(false, boardService.delete(2, "1111"));
  }

  @Transactional
  @Test
  public void delete성공Test() {
    assertEquals(true, boardService.delete(2,"1234"));
  }
}
