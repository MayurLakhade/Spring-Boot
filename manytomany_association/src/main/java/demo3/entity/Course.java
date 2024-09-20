package demo3.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;
    private double fees;

    @ManyToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private List<Student> student = new ArrayList<Student>();

    public Course()
    {

    }

    public Course(int id, String courseName, double fees, List<Student> student) {
        this.id = id;
        this.courseName = courseName;
        this.fees = fees;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", fees=" + fees + ", student=" + student + "]";
    }
    

    
}
