package net.ict.ict01.domain;

import lombok.*;

import javax.persistence.*;

@Entity // Entity 애너테이션을 이용하면 반드시 프라이머리 키로 지정해줘야 한다
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{ // BascEntity의 설정값들을 사용할 수 있도록 상속시켜줌

    @Id // 기본키 직접 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동생성 해주는 애너테이션
    private Long bno;

    @Column(length = 100, nullable = false) // DB 테이블과 동일하게 설정
    private String title;

    @Column(length = 200, nullable = false) // DB 테이블과 동일하게 설정
    private String content;

    @Column(length = 50, nullable = false) // DB 테이블과 동일하게 설정
    private String writer;

    public void change(String title, String content) { // Test에서 update하기 위해서 필요
        this.title = title;
        this.content = content;
    }
}
