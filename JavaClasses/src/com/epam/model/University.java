package com.epam.model;

import java.util.*;

public class University {
    List<Student> students = new ArrayList<>();

    public void addStudentIntoUniversity (Student student){
        students.add(student);
    }

    public void getStudentsOfFaculty(String faculty){
        if(faculty == null){
            return;
        }
        printFacultyStudentList(faculty);
    }

    public void getListOfStudentsOfEachFaculty(){
        Set<String> faculties = new HashSet<>();
        for (Student student : students){
            faculties.add(student.getFaculty());
        }
        for (String faculty : faculties){
            printFacultyStudentList(faculty);
        }
    }

    private void printFacultyStudentList(String faculty) {
        System.out.println("List of students, studied in \"" + faculty + "\":");
        for (Student student : students) {
            if (faculty.equals(student.getFaculty())) {
                System.out.println(student.getSimpleName());
            }
        }
    }

    public void getListOfStudentsOfEachCourse() {
        Set<Integer> courses = new HashSet<>();
        for (Student student : students){
            courses.add(student.getCourse());
        }
        for (Integer course : courses){
            System.out.println("List of students of " + course + " course:");
            for (Student student : students){
                if (student.getCourse() == course){
                    System.out.println(student.getSimpleName());
                }
            }
        }
    }

    public void getListOfStudentsWithYearOfBirthAfter (int year){
        System.out.println("List of students, after " + year + " year:");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);

        for (Student student : students){
            if (student.getDateOfBirth().getTime() > calendar.getTimeInMillis()){
                System.out.println(student.getSimpleName());
            }
        }
    }

    public void getStudentsOfGroup (String group){
        System.out.println("List of students by " + group + ":");
        for (Student student : students){
            if (group.equals(student.getGroup())){
                System.out.println(student.getSimpleName());
            }
        }
    }
}
