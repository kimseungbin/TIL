package io.wisoft.java_seminar.chap06.sec11.exam01_final_field;

public class Person {
    final String nation = "Korea";
    final String ssn;
    String name;

    public Person(String ssn, String name) {
        this.ssn = ssn;
        this.name = name;
    }
}
