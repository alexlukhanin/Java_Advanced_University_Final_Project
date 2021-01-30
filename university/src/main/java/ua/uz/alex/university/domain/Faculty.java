/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.domain.Faculty  - domain layer
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.domain;


import java.util.List;

public class Faculty {

    private Integer id;

    private FacultyName name;

    private Integer numberOfStudents;

    private List<Subject> subjects;

    public Faculty() {
    }

    public Faculty(Integer id, FacultyName name, Integer numberOfStudents, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.subjects = subjects;
    }

    public Faculty(FacultyName name, Integer numberOfStudents, List<Subject> subjects) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FacultyName getName() {
        return name;
    }

    public void setName(FacultyName name) {
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

        if (id != null ? !id.equals(faculty.id) : faculty.id != null) return false;
        if (name != faculty.name) return false;
        if (numberOfStudents != null ? !numberOfStudents.equals(faculty.numberOfStudents) : faculty.numberOfStudents != null)
            return false;
        return subjects != null ? subjects.equals(faculty.subjects) : faculty.subjects == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (numberOfStudents != null ? numberOfStudents.hashCode() : 0);
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name=" + name +
                ", numberOfStudents=" + numberOfStudents +
                ", subjects=" + subjects +
                '}';
    }
}
