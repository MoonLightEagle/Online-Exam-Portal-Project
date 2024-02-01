package com.medev.onlineexamportalbackend.service;

import com.medev.onlineexamportalbackend.dto.CreateTeacherRequest;
import com.medev.onlineexamportalbackend.dto.StudentCourseDTO;
import com.medev.onlineexamportalbackend.dto.UpdateTeacherRequest;
import com.medev.onlineexamportalbackend.entity.Student;
import com.medev.onlineexamportalbackend.entity.Teacher;
import com.medev.onlineexamportalbackend.mapper.TeacherMapper;
import com.medev.onlineexamportalbackend.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseService courseService;
    private final StudentService studentService;
    private final TeacherMapper teacherMapper;

    public Teacher createTeacher(CreateTeacherRequest createTeacherRequest) {
        return teacherRepository.save(teacherMapper.mapToTeacher(createTeacherRequest));
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher deleteTeacherById(Long id) {
        Teacher deletedTeacher = teacherRepository.findById(id).get();

        teacherRepository.deleteById(id);

        return deletedTeacher;
    }

    public Teacher updateTeacherById(Long id, UpdateTeacherRequest updateTeacherRequest) {
        Teacher oldTeacher = teacherRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        teacherMapper.mapToTeacher(updateTeacherRequest, oldTeacher);
        return teacherRepository.save(oldTeacher);
    }

    public Student updateStudentToCourse(StudentCourseDTO studentCourseDTO, Long teacherId) {

        Teacher teacher = teacherRepository.findById(teacherId).get();
        if (teacher.getCourses().contains(studentCourseDTO.getCourseId())) {
            courseService.addStudentToCourse(studentCourseDTO.getStudentId(), studentCourseDTO.getCourseId());
        }
        return studentService.getStudentById(studentCourseDTO.getStudentId());
    }
}
