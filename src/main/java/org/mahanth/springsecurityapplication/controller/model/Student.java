package org.mahanth.springsecurityapplication.controller.model;

public class Student {

    private int studentId;
    private String studentName;
    private int studentMarks;

    public Student(){

    }
    public Student(int studentId, String studentName, int studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }

    public int getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public int getStudentMarks() {
        return studentMarks;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setStudentMarks(int studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Override
    public String toString() {
        return "StudentController{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentMarks=" + studentMarks +
                '}';
    }
}
