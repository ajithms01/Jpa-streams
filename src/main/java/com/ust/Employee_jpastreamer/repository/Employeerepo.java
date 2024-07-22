package com.ust.Employee_jpastreamer.repository;

import com.ust.Employee_jpastreamer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Employeerepo extends JpaRepository<Employee,Integer> {
}
