package io.jongbeom.springboot.intellij.learnjpaandhibernate.course.jpa;

import io.jongbeom.springboot.intellij.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext //컨테이너 관리형 엔티티메니저 및 그에 연결된 영속성 컨텍스트와 종속성을 지정
    private EntityManager entityManager;    //데이터베이스와 엔티티 객체(Entity) 사이의 상호작용을 관리하는 매니저

    public void insert(Course course){
        entityManager.merge(course); // 해당 행 추가
    }

    public Course findById(long id){
        return entityManager.find(Course.class,id);

    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class,id);    //해당 ID 값의 행을 검색 후 저장
        entityManager.remove(course); // 해당 값을 제거
    }

}



