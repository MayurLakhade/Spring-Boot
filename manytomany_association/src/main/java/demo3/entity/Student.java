package demo3.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String age;

    private String dept;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Student_CourseTable",joinColumns = @JoinColumn( name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name ="course_id", referencedColumnName = "id"))
    private List<Course> course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

     @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + ", course=" + course + "]";
    }
    
       public Student() {
    }

    public Student(int id, String name, String age, String dept, List<Course> course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.course = course;
    }

    
    
}
