package com.spring.today_memo.controller;

import com.spring.today_memo.domain.Memo;
import com.spring.today_memo.domain.MemoRepository;
import com.spring.today_memo.domain.MemoRequestDto;
import com.spring.today_memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // 리스트 조회
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(yesterday, now);
    }

    // 상세페이지 조회
    @GetMapping("/api/memo/{id}")
    public Optional<Memo> getMemo(@PathVariable Long id) {
        return memoRepository.findById(id);
    }

    // 작성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    // 수정
    @PutMapping("/api/update/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    // 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }



}