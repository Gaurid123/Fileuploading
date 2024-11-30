package com.cjc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Student11;

@Repository
public interface StudentRepository extends JpaRepository<Student11, Integer> {

}
