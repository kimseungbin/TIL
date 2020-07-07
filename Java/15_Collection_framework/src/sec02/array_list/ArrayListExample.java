package io.wisoft.java_seminar.chap15.sec02.array_list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    // String 객체 저장
    list.add("Java");
    list.add("JDBC");
    list.add("Servlet/JSP");
    list.add(2, "Database");
    list.add("iBATIS");

    int size = list.size(); // 저장된 총 객체 수 얻기
    System.out.println("총 객체수: " + size);
    System.out.println();

    String skill = list.get(2); // 2번 인덱스의 객체 얻기
    System.out.println("2: " + skill);
    System.out.println();

    for (int i = 0; i < list.size(); i++) {
      String str = list.get(i);
      System.out.println(i + ":" + str);
    }
    System.out.println();

    list.remove(2); // 2번 인덱스 객체(Database) 삭제
    list.remove(2); // 2번 인덱스 객체(Servlet/JSP) 삭제
    list.remove("iBATIS");

    for (int i = 0; i < list.size(); i++) {
      String str = list.get(i);
      System.out.println(i + ":" + str);
    }
  }

}
