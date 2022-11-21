package net.ict.ict01.repository;

import lombok.extern.log4j.Log4j2;
import net.ict.ict01.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@SpringBootTest
@Log4j2 // 콘솔창에 뿌리기위해서 필요
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    //save() 결과는 데이터베이스에 저장된 데이터와 동기화된 Board Entity 객체가 반환 확인
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i->{
                    Board board = Board.builder()
                            .title("title------"+i)
                            .content("content------"+i)
                            .writer("user------"+(i%10))
                            .build();

                    Board result = boardRepository.save(board);
                    log.info("BNO : " + result.getBno());
                });
    }

    @Test
    public void testSelect(){
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        log.info(board);
    }

    @Test
    // 1. 지정한 bno의 row값을 지정하고 result에 담고 2. 지정한 컬럼에 수정할 내용을 담고 3. 음...
    public void testUpdate(){
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow(); // 얘가 2번 같은데 위에 적은 2. 는 3번같은데 아래꺼
        board.change("update..title 100","update content 100");
        boardRepository.save(board);
    }

    @Test
    public void testDelete(){
        Long bno = 1L;
        boardRepository.deleteById(bno);
    }

    @Test
    public void testPaging(){
        // 1 page order by bno desc
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending()); // Sort.by("bno").descending()는 정렬 조건
        Page<Board> result = boardRepository.findAll(pageable);

        log.info("total count:"+result.getTotalElements());
        log.info("total pages:"+result.getTotalPages());
        log.info("page number:"+result.getNumber());
        log.info("page size:"+result.getSize());
        List<Board> todoList = result.getContent();
        todoList.forEach(board -> log.info(board));
    }

    @Test
    public void testSearch1(){
        Pageable pageable = PageRequest.of(1,10,Sort.by("bno").descending());
        boardRepository.search1(pageable);
    }




}
