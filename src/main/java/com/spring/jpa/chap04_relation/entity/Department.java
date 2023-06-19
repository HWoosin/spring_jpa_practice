package com.spring.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude ="employees" )
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_dept")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private long id;

    @Column(name = "dept_name", nullable = false)
    private String name;

    //양방향해보기
    //상대방 엔터티의 갱신에 관여할 수 없다.
    //단순히 읽기전용(조회)로만 사용해야 한다.
    @OneToMany(mappedBy = "department")//mappedBy에는 상대방 엔터티의 조인되는 필드명을 작성. Employee에서 department 가져왔음.
    private List<Employee> employees = new ArrayList<>();//1대 다 이므로 리스트받기 그치만 읽기 전용, 초기화가 필요.(NPE 방지)


}
