package com.epam.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;

    private Date dateOfBirth;

    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private String group;

    private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Student() {
    }

    public Student(int id, String lastName, String firstName, String middleName, Date dateOfBirth, String address, String phoneNumber, String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dayOfBirth=" + dateFormat.format(dateOfBirth) +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                '}';
    }

    public String getSimpleName(){
        return lastName + " " + firstName.charAt(0) + ". " + middleName.charAt(0) + ". "+ dateFormat.format(dateOfBirth);
    }

    public static class StudentBuilder{
        private final Student newStudent;

        public StudentBuilder (){
            newStudent = new Student();
        }

        public StudentBuilder withId (int id){
            newStudent.id = id;
            return this;
        }

        public StudentBuilder withLastName (String lastName){
            newStudent.lastName = lastName;
            return this;
        }

        public StudentBuilder withFirstName (String firstName){
            newStudent.firstName = firstName;
            return this;
        }

        public StudentBuilder withMiddleName (String middleName){
            newStudent.middleName = middleName;
            return this;
        }

        public StudentBuilder withDateOfBirth (Date dateOfBirth){
            newStudent.dateOfBirth = dateOfBirth;
            return this;
        }

       public StudentBuilder withAddress (String address){
            newStudent.address = address;
            return this;
        }

        public StudentBuilder withPhoneNumber (String phoneNumber){
            newStudent.phoneNumber = phoneNumber;
            return this;
        }

        public StudentBuilder withFaculty (String faculty){
            newStudent.faculty = faculty;
            return this;
        }

        public StudentBuilder withCourse (int course){
            newStudent.course = course;
            return this;
        }

        public StudentBuilder withGroup (String group){
            newStudent.group = group;
            return this;
        }

        public Student build (){
            return newStudent;
        }
    }
}
