package com.spring.jpa.chap04_relation.repository;

import com.spring.jpa.chap04_relation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepository extends JpaRepository<Employee, Long> {
}
