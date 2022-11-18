package net.ict.ict01.repository.search;

import net.ict.ict01.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// 페이지처리 기능으로 사용할 인터페이스
public interface BoardSearch {

    Page<Board> search1(Pageable pageable);



}
