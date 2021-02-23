/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.domain.Faculty  - domain layer
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.dto;


import ua.uz.alex.university.domain.Subject;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


public class FacultyDto {

    private Integer id;
    private String name;
    private Integer numberOfStudents;
    private String logoUrl;
    private List<Subject> subjects;

    public FacultyDto() {
    }

    public FacultyDto(Integer id, String name, Integer numberOfStudents, String logoUrl, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.logoUrl = logoUrl;
        this.subjects = subjects;
    }

    public FacultyDto(String name, Integer numberOfStudents, String logoUrl, List<Subject> subjects) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.logoUrl = logoUrl;
        this.subjects = subjects;
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }


}
