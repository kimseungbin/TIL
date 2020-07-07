package io.wisoft.java_seminar.chap10.sec03.exception;

public class TryCatchFinallyExample {

  public static void main(String[] args) {
    try {
      // Class.forName() 메소드 : 매개값으로 주어진 클래스가 존재하면 Class 객체를 리턴
      // 존재하지 않으면 ClassNotFoundException 예외 발생
      Class clazz = Class.forName("java.lang.String2");
    } catch (ClassNotFoundException e) {
      System.out.println("클래스가 존재하지 않습니다.");
    }
  }

}
