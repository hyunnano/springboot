package net.ict.ict01.domain;

// 데이터베이스의 거의 모든 테이블은 데이터가 추가되거나 수정된 시간 등 테이블객체의 변화에 대한 정보들을
// 저장하여 관리한다. 자바에서 쉽게 처리하기 위해 @MappedSuperclass 를 이용하여
// 공통 컬럼들을 지정하고 해당 클래스를 상속하여 처리하도록 한다.

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract class BaseEntity { // 추상클래스

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;




}
