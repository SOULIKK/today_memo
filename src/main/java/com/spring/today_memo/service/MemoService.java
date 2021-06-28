package com.spring.today_memo.service;


import com.spring.today_memo.domain.Memo;
import com.spring.today_memo.domain.MemoRepository;
import com.spring.today_memo.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 메모입니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }

}
