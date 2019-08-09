package order.example.searcher.model;

import java.io.Serializable;

public class FilterDto implements Serializable {

    private String name;
    private String email;
    private Integer age;
    private String course;

    public String getName() {
        return name;
    }

    public FilterDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FilterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public FilterDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public FilterDto setCourse(String course) {
        this.course = course;
        return this;
    }
}
