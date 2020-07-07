package io.wisoft.java_seminar.chap11.sec04.to_string;

import java.util.Objects;

public class ToStringExample {

  public static void main(String[] args) {
    String str1 = "홍길동";
    String str2 = null;

    System.out.println(Objects.toString(str1));
    System.out.println(Objects.toString(str2));
    System.out.println(Objects.toString(str2, "이름이 없습니다."));
  }

}
