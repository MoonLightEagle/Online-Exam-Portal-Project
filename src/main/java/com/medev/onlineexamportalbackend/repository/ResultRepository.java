package com.medev.onlineexamportalbackend.repository;

import com.medev.onlineexamportalbackend.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {
}
