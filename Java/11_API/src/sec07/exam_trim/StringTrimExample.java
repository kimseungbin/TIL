package io.wisoft.java_seminar.chap11.sec07.exam_trim;

public class StringTrimExample {

  public static void main(String[] args) {
    String tel1 = "   02";
    String tel2 = "123   ";
    String tel3 = "   1234   ";

    String tel = tel1.trim() + tel2.trim() + tel3.trim();
    System.out.println(tel);
  }

}
