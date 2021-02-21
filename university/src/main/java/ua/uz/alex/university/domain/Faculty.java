/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.domain.Faculty  - domain layer
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.domain;


import org.apache.logging.log4j.util.Strings;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberOfStudents")
    private Integer numberOfStudents;

    private String logoUrl;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="faculty_subject",
            joinColumns=@JoinColumn(name="faculty_id"),
            inverseJoinColumns=@JoinColumn(name="subject_id")
    )
    private List<Subject> subjects;

    public Faculty() {
    }

    public Faculty(Integer id, String name, Integer numberOfStudents, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.subjects = subjects;
    }

    public Faculty(String name, Integer numberOfStudents, List<Subject> subjects) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.subjects = subjects;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }



    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) &&
                Objects.equals(name, faculty.name) &&
                Objects.equals(numberOfStudents, faculty.numberOfStudents) &&
                Objects.equals(logoUrl, faculty.logoUrl) &&
                Objects.equals(subjects, faculty.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfStudents, logoUrl, subjects);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                ", subjects=" + subjects +
                '}';
    }
}
