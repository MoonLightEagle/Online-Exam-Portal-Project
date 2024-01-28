package com.medev.onlineexamportalbackend.repository;

import com.medev.onlineexamportalbackend.entity.Exam;
import com.medev.onlineexamportalbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {
    @Query("SELECT s FROM Student s JOIN FETCH s.exams e WHERE e.id = :examId")
    public List<Student> findStudentsByExamId(Long examId);
}
