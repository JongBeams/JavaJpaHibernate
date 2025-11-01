package io.jongbeom.springboot.intellij.learnjpaandhibernate.course.jdbc;

import io.jongbeom.springboot.intellij.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                    insert into course (id,name,author)
                    values (?,?,?);
            """;// 텍스트 블록, ? 설정 시 springJdbcTemplate.update에서 메게변수로 String sql로 취급되며, ?를 뒤에 매게변수를 추가하여 set가능하다.

    private static String DELETE_QUERY =
            """
                    delete from course where id =?;
                    
            """;

    private static String SELECT_QUERY =
            """
                    select*from course where id=?;
            """;



    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course findById(long id){
        //resultset(select로 얻은 결과값 ) -> bean에 매핑 => row mapper를 사용해 매핑
        return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
        // BeanPropertyRowMapper 사용시 테이블과 일치하는 Bean으로 매핑할 수 있다.

    }


}
