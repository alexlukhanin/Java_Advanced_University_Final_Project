/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.domain.RegistrationForFaculty  - domain layer
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.Base64;
import java.util.List;


@Entity
@Table(name = "faculty_registrations")
public class RegistrationForFaculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private Faculty faculty;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ElementCollection
    private List<Integer> marks;

    @Column(name = "upload_file")
    private String uploadFile;

    @Column(name = "marks_sum")
    private Integer marksSum;

    @Transient
    private int facultyId;

    @Transient
    private String email;

    public RegistrationForFaculty() {
    }

    public RegistrationForFaculty(Faculty faculty, User user, List<Integer> marks, MultipartFile file) throws IOException {
        this.faculty = faculty;
        this.user = user;
        this.marks = marks;
        this.uploadFile = Base64.getEncoder().encodeToString(file.getBytes());
        this.marksSum = marks.stream().reduce(0, Integer::sum);
    }

    public RegistrationForFaculty(Integer id, Faculty faculty, User user, List<Integer> marks, MultipartFile file) throws IOException {
        this.id = id;
        this.faculty = faculty;
        this.user = user;
        this.marks = marks;
        this.uploadFile = Base64.getEncoder().encodeToString(file.getBytes());
        this.marksSum = marks.stream().reduce(0, Integer::sum);
    }


    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }

    public Integer getMarksSum() {
        return marksSum;
    }

    public void setMarksSum(Integer marksSum) {
        this.marksSum = marksSum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationForFaculty that = (RegistrationForFaculty) o;

        if (facultyId != that.facultyId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (faculty != null ? !faculty.equals(that.faculty) : that.faculty != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (marks != null ? !marks.equals(that.marks) : that.marks != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (marks != null ? marks.hashCode() : 0);
        result = 31 * result + facultyId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }


}
