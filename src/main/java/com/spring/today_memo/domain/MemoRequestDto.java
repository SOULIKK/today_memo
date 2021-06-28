package com.spring.today_memo.domain;


import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String username;
    private String title;
    private String content;
}
