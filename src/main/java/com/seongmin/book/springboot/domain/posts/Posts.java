package com.seongmin.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dom4j.swing.XMLTableColumnDefinition;

import javax.persistence.*;


/*
Entity클래스에서는 절대 Setter를 만들지 않는다.
인스턴스 값들이 어디서 변해야 하는지 코드상으로 구분할 수가 없어, 기능 변경시 복잡해진다.
만약 값의 변경이 필요하다면, 목적과 의도를 나타낼수 있는 메소드를 추가하는게 좋다.
ex)
public class Order{
    public void cancelOrder(){
        this.status = false;
    }
}
public void 주문취소()
{
    order.cancelOrder();
}
*/
@Getter
//getter 메소드 자동 생성
@NoArgsConstructor
//기본생성자 자동 추가
//△롬복의 어노테이션 코드를 단순화 시켜주지만 꼭 필수 어노테이션은 아니다.
@Entity
//JPA의 어노테이션, 주요 어노테이션을 클래스에 가까이 두는 습관이 좋다. 테이블과 링크될 클래스임을 나타낸다.
public class Posts {
    @Id
    //entity의 PK임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK의 생성규칙, IDENTITY옵션을 추가해야지 auto_increment가 된다.(키의 자동증가)
    private Long id;
    @Column(length = 500,nullable=false)
        /*
        테이블의 칼럼을 나타낸다. 선언하지 않아도 모든 필드는 칼럼이 되지만, 옵션이 필요할 경우 사용한다.
        이 경우는 String의 길이가 255까지인데 500으로 늘리기 위해 사용
        */
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    //이 경우에서는 타입을 TEXT로 변경하기 위해서 사용
    private String content;

    private String author;

    //public static Postsbuilder builder(){ return new Postsbuilder(); }
    //위는 직접 구현
    @Builder
    //클래스의 빌더패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
