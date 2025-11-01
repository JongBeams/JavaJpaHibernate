package io.jongbeom.springboot.intellij.learnjpaandhibernate.course;

import io.jongbeom.springboot.intellij.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import io.jongbeom.springboot.intellij.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import io.jongbeom.springboot.intellij.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//CommandLineRunner - Bean이 SpringApplication 안에 포함되어 있을 때 실행된다는 의미로 쓰이는 인터페이스
//스프링 애플리케이션 시작시에 실행될 로직이 있을 때 CommandLineRunner 사용
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    //스프링 컨텍스트가 초기화된 직후(빈 생성/주입 완료 후) 자동 호출되는 스타트업 훅
    @Override
    public void run(String... args) throws Exception {
        //JDBC, JPA 명령어
        /*
        repository.insert(new Course(1,"LearnDB","JangJongBeom"));
        repository.insert(new Course(2,"LearnAWS","JangJongBeom"));
        repository.insert(new Course(3,"LearnDevOps","JangJongBeom"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
        */
        //Spring data jpa에서는 insert가 save로 사용
        repository.save(new Course(1,"LearnDB","JangJongBeom"));
        repository.save(new Course(2,"LearnAWS","JangJongBeom"));
        repository.save(new Course(3,"LearnDevOps","JangJongBeom"));

        //id의 데이터 타입이 long이기에 뒤에 l을 붙여 데이터 타입 변환
        repository.deleteById(1l);

        //Spring data jpa 에서는 기본적으로 deleteById, findById 메소드를 제공한다. 따라서 이름을 변경할 필요는 없다.
        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        //Spring data jpa에서 기본 제공하는 메소드의 종류가 많다.
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        //커스텀 메소드 실행
        System.out.println(repository.findAllByAuthor("JangJongBeom"));
        System.out.println(repository.findAllByAuthor(""));

        System.out.println(repository.findAllByName("LearnDB"));
        System.out.println(repository.findAllByName("LearnDevOps"));

    }
}
