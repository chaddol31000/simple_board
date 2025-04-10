package com.example.simple_board.board;

import lombok.*;

import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Board {
  private Integer bno;
  private String title;
  private String content;
  private String nickname;
  private String password;
  private LocalDateTime writeTime;
  private Integer readCnt;
}
