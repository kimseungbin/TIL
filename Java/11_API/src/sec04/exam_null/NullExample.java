package io.wisoft.java_seminar.chap11.sec04.exam_null;

import java.util.Objects;

public class NullExample {

  public static void main(String[] args) {
    String str1 = "홍길동";
    String str2 = null;

    System.out.println(Objects.requireNonNull(str1));


    try {
      String name = Objects.requireNonNull(str2);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      String name = Objects.requireNonNull(str2, "이름이 없습니다.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {										                    // 두 번째 매개값으로 람다식
      String name = Objects.requireNonNull(str2, () -> "이름이 없다니깐요");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
