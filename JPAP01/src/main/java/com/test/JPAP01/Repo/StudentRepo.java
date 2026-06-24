package com.test.JPAP01.Repo;

import com.test.JPAP01.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interview- Diff between JpaRepository and CrudRepository
@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
