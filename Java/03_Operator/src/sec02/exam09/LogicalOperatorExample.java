package io.wisoft.java_seminar.chap03.sec02.exam09;

public class LogicalOperatorExample {

    public static void main(String[] args) {
        int charCode = 'A';

        if ((charCode >= 65) & (charCode <= 90)) {
            System.out.println("대문자군요ㅎㅎ");
        }

        if ((charCode >= 97) && (charCode <= 122)) {
            System.out.println("소문자군요ㅎㅎ");
        }

        if ((charCode < 48) && !(charCode > 57)) {
            System.out.println("0~9 숫자군요ㅎㅎ");
        }

        int value = 6;

        if ((value % 2 == 0) | (value % 3 == 90)) {
            System.out.println("2 또는 3의 배수군요ㅎㅎ");
        }

        if ((value % 2 == 0) || (value % 3 == 90)) {
            System.out.println("2 또는 3의 배수군요ㅎㅎ");
        }
    }

}
