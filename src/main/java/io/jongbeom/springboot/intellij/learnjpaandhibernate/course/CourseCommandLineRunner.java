package io.jongbeom.springboot.intellij.learnjpaandhibernate.course;

import io.jongbeom.springboot.intellij.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import io.jongbeom.springboot.intellij.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//CommandLineRunner - Bean이 SpringApplication 안에 포함되어 있을 때 실행된다는 의미로 쓰이는 인터페이스
//스프링 애플리케이션 시작시에 실행될 로직이 있을 때 CommandLineRunner 사용
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;

    //스프링 컨텍스트가 초기화된 직후(빈 생성/주입 완료 후) 자동 호출되는 스타트업 훅
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"LearnDB","JangJongBeom"));
        repository.insert(new Course(2,"LearnAWS","JangJongBeom"));
        repository.insert(new Course(3,"LearnDevOps","JangJongBeom"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));

    }
}
