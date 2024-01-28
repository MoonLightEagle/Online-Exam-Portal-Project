package com.medev.onlineexamportalbackend.repository;

import com.medev.onlineexamportalbackend.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface GradeRepository  extends JpaRepository<Grade,Long> {
}
