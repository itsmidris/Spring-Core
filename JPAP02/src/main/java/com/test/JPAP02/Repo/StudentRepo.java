package com.test.JPAP02.Repo;

import com.test.JPAP02.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
