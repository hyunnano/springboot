package net.ict.ict01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // BaseEntity.java에 있는 AuditingEntityListener를 활성화 시키는 설정
@SpringBootApplication // Application이 총괄 책임자 클래스
public class Ict01Application { // Application이 총괄 책임자 클래스

    public static void main(String[] args) {
        SpringApplication.run(Ict01Application.class, args);
    }

}
