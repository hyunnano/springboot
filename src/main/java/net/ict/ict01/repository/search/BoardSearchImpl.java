package net.ict.ict01.repository.search;

import com.querydsl.jpa.JPQLQuery;
import net.ict.ict01.domain.Board;
import net.ict.ict01.domain.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch{

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        QBoard board = QBoard.board; // Q도메인 객체
        JPQLQuery<Board> query = from(board); // Q보드 / select * from board; 와 같은 의미
        query.where(board.title.contains("1")); // 조건 where
        this.getQuerydsl().applyPagination(pageable,query);
        List<Board> list = query.fetch();
        long count = query.fetchCount();
        return null;
    }
}
