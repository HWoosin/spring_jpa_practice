package com.spring.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
//jpa연관관계 매핑에서 연관관계 데이터는 toString에서 제외해야한다.
@ToString(exclude = "department")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_emp")
public class Employee {//얘가 N

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto Increment사용~!
    @Column(name = "emp_id")
    private long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    //단방향
    //EAGER: 항상 무조건 조인을 수행
    //LAZY: 필요한 경우에만 조인을 수행
    @ManyToOne(fetch = FetchType.LAZY)//얘가 1
    @JoinColumn(name = "dept_id")//컬럼과 연결
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
        department.getEmployees().add(this);
    }
}
