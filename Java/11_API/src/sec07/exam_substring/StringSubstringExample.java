package io.wisoft.java_seminar.chap11.sec07.exam_substring;

public class StringSubstringExample {

  public static void main(String[] args) {
    String ssn = "970528-1234567";

    String firstNum = ssn.substring(0, 6);
    System.out.println(firstNum);

    String secondNum = ssn.substring(7);
    System.out.println(secondNum);
  }

}
