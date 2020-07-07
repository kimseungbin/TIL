package io.wisoft.java_seminar.chap11.sec07.exam_case;

public class StringToLowerUpperCaseExample {

  public static void main(String[] args) {
    String str1 = "Java Programming";
    String str2 = "JAVA PROGRAMMING";

    System.out.println(str1.equals(str2));

    String lowerStr1 = str1.toLowerCase();
    String lowerStr2 = str2.toLowerCase();
    System.out.println(lowerStr1.equals(lowerStr2));

    // 대소문자를 맞추는 작업을 생략할 수 있다.
    System.out.println(str1.equalsIgnoreCase(str2));
  }

}
