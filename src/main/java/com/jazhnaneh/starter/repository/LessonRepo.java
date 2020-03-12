package com.jazhnaneh.starter.repository;

import com.jazhnaneh.starter.model.Lesson;
import com.jazhnaneh.starter.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepo extends PagingAndSortingRepository<Lesson,Long> {



    Optional<Lesson> findByLessonId(Long lessonId);
//

    List<Lesson> findAllByStudent(Student student);


//
//    Optional<Student> findByName(String name);
//
//    List<Student> findAllByAge(Integer age);
    List<Lesson> findAll();
//
    Page<Lesson> findAll(Pageable pageable);
//

}