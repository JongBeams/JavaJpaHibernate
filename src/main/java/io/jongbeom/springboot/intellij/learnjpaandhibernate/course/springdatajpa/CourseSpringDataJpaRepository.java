package io.jongbeom.springboot.intellij.learnjpaandhibernate.course.springdatajpa;

import io.jongbeom.springboot.intellij.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository
        extends JpaRepository<Course,Long> {// 스프링 데이터 JAP 사용시 인터페이스에 상속을 통한 JPA 리포지토리를 사용해 관리,<관리할 객체,ID 필드>


    //커스텀 메서드 정의 - 생성 시 명명 규칙을 지켜야한다.(ex: find => findBy)
    List<Course> findAllByAuthor(String author);

    List<Course> findAllByName(String name);
}
