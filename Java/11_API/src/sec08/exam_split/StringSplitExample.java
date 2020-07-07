package io.wisoft.java_seminar.chap11.sec08.exam_split;

public class StringSplitExample {

  public static void main(String[] args) {
    String text = "홍길동&김승빈,박자바,김자바-안자바";

    String[] names = text.split("&|,|-");

    for (String name : names) {
      System.out.println(name);
    }
  }

}
