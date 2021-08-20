package src;

public class UniversityRunner {
    public static void main(String[] args) {
        University university = new University();
        university.addStudentIntoUniversity(new Student.StudentBuilder()
                .withId(1)
                .withLastName("Иванов")
                .withFirstName("Иван")
                .withMiddleName("Иванович")
                .withDayOfBirth(12)
                .withMonthOfBirth("апрель")
                .withYearOfBirth(2000)
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
                .withDayOfBirth(17)
                .withMonthOfBirth("февраль")
                .withYearOfBirth(2001)
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
                .withDayOfBirth(17)
                .withMonthOfBirth("сентябрь")
                .withYearOfBirth(2000)
                .withAddress("ул.Карского, 1-111")
                .withPhoneNumber("+375 29 333-33-33")
                .withFaculty("ММФ")
                .withCourse(3)
                .withGroup("ММФ18")
                .build());
        university.addStudentIntoUniversity(new Student(4, "Сидоров", "Евгений", "Александрович", 22, "апрель", 1999, "ул.Уманская, 7-24", "+375 29 212-14-62", "ММФ", 4, "ММФ17"));
        university.addStudentIntoUniversity(new Student(5, "Лисовский", "Максим", "Анатольевич", 1, "ноябрь", 1999, "ул.Тимошенко, 10-16", "+375 29 715-15-21", "КСС", 4, "КСС17"));
        university.addStudentIntoUniversity(new Student(6, "Глинник", "Григорий", "Тимофеевич", 16, "март", 1999, "ул.Федорова, 6-36", "+375 29 999-99-99", "ММФ", 4, "ММФ17"));

        university.getStudentsOfFaculty("КП");
        System.out.println();
        university.getStudentsOfGroup("ММФ17");
        System.out.println();
        university.getListOfStudentsOfEachFaculty();
        System.out.println();
        university.getListOfStudentsOfEachCourse();
        System.out.println();
        university.getListOfStudentsWithYearOfBirthAfter(2000);
    }
}
