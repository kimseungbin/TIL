package io.wisoft.java_seminar.chap06.sec08.exam04_overloading;

public class CalculatorExample {

    public static void main(String[] args) {
        Calculator myCalc = new Calculator();

        // 정사각형의 넓이
        double result1 = myCalc.areaRectangle(10);

        // 직사각형의 넓이
        double result2 = myCalc.areaRectangle(10, 20);

        // 결과 출력
        System.out.println("정사각형의 넓이=" + result1);
        System.out.println("직사각형의 넓이=" + result2);
    }

}
