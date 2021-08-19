package JavaClassesMainTaskStudent;

import java.util.ArrayList;
import java.util.HashSet;

public class University {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudentIntoUniversity (Student student){
        students.add(student);
    }

    public void getStudentsOfFaculty(String faculty){
        System.out.println("Список студентов факультета \"" + faculty + "\":" );
        for (Student student : students){
            if (student.getFaculty().equals(faculty)){
                System.out.println(student.getSimpleName());
            }
        }
    }

    public void getListOfStudentsOfEachFaculty(){
        HashSet<String> faculties = new HashSet<>();
        for (Student student : students){
            faculties.add(student.getFaculty());
        }
        for (String faculty : faculties){
            System.out.println("Список студентов факультета \"" + faculty + "\":");
            for (Student student : students){
                if (student.getFaculty().equals(faculty)){
                    System.out.println(student.getSimpleName());
                }
            }
        }
    }

    public void getListOfStudentsOfEachCourse() {
        HashSet<Integer> courses = new HashSet<>();
        for (Student student : students){
            courses.add(student.getCourse());
        }
        for (Integer course : courses){
            System.out.println("Список студентов " + course + " курса:");
            for (Student student : students){
                if (student.getCourse() == course){
                    System.out.println(student.getSimpleName());
                }
            }
        }
    }

    public void getListOfStudentsWithYearOfBirthAfter (int year){
        System.out.println("Список студентов родившихся после " + year + " года:");
        for (Student student : students){
            if (student.getYearOfBirth() > year){
                System.out.println(student.getSimpleName());
            }
        }
    }

    public void getStudentsOfGroup (String group){
        System.out.println("Список студентов группы " + group + ":");
        for (Student student : students){
            if (student.getGroup().equals(group)){
                System.out.println(student.getSimpleName());
            }
        }
    }
}
