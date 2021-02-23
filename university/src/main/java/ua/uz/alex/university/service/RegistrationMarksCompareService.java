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
        Integer reduce1 = t1.getMarks().stream().reduce(0, Integer::sum);
        Integer reduce2 = t2.getMarks().stream().reduce(0, Integer::sum);

        return reduce1 < reduce2 ? 1 : -1;
    }
}
