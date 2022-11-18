package net.ict.ict01.repository;

import net.ict.ict01.domain.Board;
import net.ict.ict01.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Spring Data JPA를 이용하여 JpaRepository 인터페이스를 이용하면 데이터베이스의 CRUD 대부분을 처리할 수 있다
// '타입' 기반으로 '코드'를 이용하여 JPQL 쿼리를 생성하고 실행하는 Q도메인클래스를 사용한다. (QBoard)

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch { // 인터페이스는 다중상속이 가능하다

    @Query(value = "select now()", nativeQuery = true) // JPQL 쿼리형태, select now() 이 쿼리를 위해서 앞에서 설정을 해준거임
    String getTime();

}
