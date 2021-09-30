package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//필수적인 어노테이션을 클래스와 가깝게 선언
//Entity는 JPA, Getter와 NoArgsConstructor는 롬복으로 필수가 아님
//위와 같은 방식으로 어노테이션 선언 시 코틀린과 같은 언어로 전환 시 롬복 삭제가 용이
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
//    Springboot 2.0 에서는 해당 옵션 추가해야 auto_increment 가능
//    1.5버전과의 차이는 https://jojoldu.tistory.com/295 참고
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
