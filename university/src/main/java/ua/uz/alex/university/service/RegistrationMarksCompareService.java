/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.RegistrationMarksCompareService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import ua.uz.alex.university.domain.RegistrationForFaculty;

import java.util.Comparator;

public class RegistrationMarksCompareService implements Comparator<RegistrationForFaculty> {
    @Override
    public int compare(RegistrationForFaculty t1, RegistrationForFaculty t2) {
        return t1.getMarksSum() < t2.getMarksSum() ? 1 : -1;
    }
}
