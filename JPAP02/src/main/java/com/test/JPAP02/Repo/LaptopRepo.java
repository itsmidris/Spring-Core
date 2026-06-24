package com.test.JPAP02.Repo;

import com.test.JPAP02.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop,Long> {
}
