package com.epam.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UniversityRunner {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        University university = new University();
        university.addStudentIntoUniversity(new Student.StudentBuilder()
                .withId(1)
                .withLastName("Иванов")
                .withFirstName("Иван")
                .withMiddleName("Иванович")
                .withDateOfBirth(df.parse("26.05.1986"))
                .withAddress("ул.Сухаревская, 16-32")
                .withPhoneNumber("+375 29 111-11-11")
                .withFaculty("КП")
                .withCourse(3)
                .withGroup("КП18")
                .build());
        university.addStudentIntoUniversity(new Student.StudentBuilder()
                .withId(2)
                .withLastName("Петров")
                .withFirstName("Петр")
                .withMiddleName("Петрович")
                .withDateOfBirth(df.parse("29.05.1987"))
                .withAddress("ул.Притыцкого, 15-25")
                .withPhoneNumber("+375 29 222-22-22")
                .withFaculty("КП")
                .withCourse(2)
                .withGroup("КП19")
                .build());
        university.addStudentIntoUniversity(new Student.StudentBuilder()
                .withId(3)
                .withLastName("Печкин")
                .withFirstName("Дмитрий")
                .withMiddleName("Геннадьевич")
                .withDateOfBirth(df.parse("26.04.1987"))
                .withAddress("ул.Карского, 1-111")
                .withPhoneNumber("+375 29 333-33-33")
                .withFaculty("ММФ")
                .withCourse(3)
                .withGroup("ММФ18")
                .build());
        university.addStudentIntoUniversity(new Student(4, "Сидоров", "Евгений", "Александрович", df.parse("26.05.1986"), "ул.Уманская, 7-24", "+375 29 212-14-62", "ММФ", 4, "ММФ17"));
        university.addStudentIntoUniversity(new Student(5, "Лисовский", "Максим", "Анатольевич", df.parse("26.05.1986"), "ул.Тимошенко, 10-16", "+375 29 715-15-21", "КСС", 4, "КСС17"));
        university.addStudentIntoUniversity(new Student(6, "Глинник", "Григорий", "Тимофеевич", df.parse("26.05.1986"), "ул.Федорова, 6-36", "+375 29 999-99-99", "ММФ", 4, "ММФ17"));

        university.getStudentsOfFaculty("КП");
        System.out.println();
        university.getStudentsOfGroup("ММФ17");
        System.out.println();
        university.getListOfStudentsOfEachFaculty();
        System.out.println();
        university.getListOfStudentsOfEachCourse();
        System.out.println();
        university.getListOfStudentsWithYearOfBirthAfter(1986);
    }
}
