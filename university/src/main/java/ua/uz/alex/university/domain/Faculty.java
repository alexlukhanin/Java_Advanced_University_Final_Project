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

    @Column(name = "logo")
    @Lob
    private String logo;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

        if (id != null ? !id.equals(faculty.id) : faculty.id != null) return false;
        if (name != null ? !name.equals(faculty.name) : faculty.name != null) return false;
        if (numberOfStudents != null ? !numberOfStudents.equals(faculty.numberOfStudents) : faculty.numberOfStudents != null)
            return false;
        if (logo != null ? !logo.equals(faculty.logo) : faculty.logo != null) return false;
        return subjects != null ? subjects.equals(faculty.subjects) : faculty.subjects == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (numberOfStudents != null ? numberOfStudents.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        return result;
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
