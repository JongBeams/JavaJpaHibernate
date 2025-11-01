package io.jongbeom.springboot.intellij.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //(name = "Course")//name 설정으로 직접매핑할 수 도 있다.
public class Course {

    @Id
    private long id;
    //@Column(name="name") //엔티티와 이름이 같기때문에 컬럼 어노테이션을 설정할 필요가 없다.
    private  String name;
    //@Column(name ="author")
    private String author;

    //인수 없는 생성자
    public Course(){
        
    }

    //생성자
    public Course(long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

    //getter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    //setter
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //to string
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
