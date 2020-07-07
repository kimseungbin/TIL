package io.wisoft.java_seminar.chap11.sec07.exam_string_constructor;

public class ByteToStringExample {

  public static void main(String[] args) {
    byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};

    String str1 = new String(bytes);
    System.out.println(str1);

    String str2 = new String(bytes, 6, 4); // 74가 들어있는 위치부터 4개
    System.out.println(str2);
  }

}
