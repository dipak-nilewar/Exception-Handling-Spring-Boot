package com.exception_h_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception_h_project.entitiy.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp , Integer> {

    public Optional<Emp> findByEname(String Ename);
}
