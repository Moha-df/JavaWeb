/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author e2500138
 */
public class Student {
    private String firstname;
    private String lastname;
    private String grades;

    public Student(String firstname, String lastname, String grades) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.grades = grades;
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getGrades() { return grades; }
}

