package com.test.LearnThymeleaf.repository;

import com.test.LearnThymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
