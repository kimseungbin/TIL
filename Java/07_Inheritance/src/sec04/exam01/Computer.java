package io.wisoft.java_seminar.chap07.sec04.exam01;

public class Computer extends Calculator{
    @Override
    double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}
