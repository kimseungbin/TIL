package io.wisoft.java_seminar.chap13.sec02.non_generic;

public class BoxExample {

  public static void main(String[] args) {
    Box box = new Box();
    box.set("홍길동");                   // String -> Object (자동 타입 변환)
    String name = (String) box.get();   // Object -> String (강제 타입 변환)

    box.set(new Apple());               // Apple -> Object (자동 타입 변환)
    Apple apple = (Apple) box.get();    // Object -> Apple (강제 타입 변환)
  }

}
