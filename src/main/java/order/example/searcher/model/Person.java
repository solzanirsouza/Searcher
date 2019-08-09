package order.example.searcher.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "person")
public class Person implements Serializable {

    private String name;
    private String email;
    private Integer age;
    private String course;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public Person setCourse(String course) {
        this.course = course;
        return this;
    }
}
