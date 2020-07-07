package io.wisoft.java_seminar.chap15.sec03.hash_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

  public static void main(String[] args) {
    Set<String> set = new HashSet<>();

    set.add("Java");
    set.add("JDBC");
    set.add("Servlet/JSP");
    set.add("Java");
    set.add("iBATIS");
    // "Java"는 한 번만 저장된다.

    int size = set.size();
    System.out.println("총 객체수: " + size);

    Iterator<String> iterator = set.iterator(); // 반복자 얻기
    while (iterator.hasNext()) { // 객체 수만큼 반복
      String element = iterator.next();
      System.out.println("\t" + element);
    }

    set.remove("JDBC");
    set.remove("iBATIS");

    System.out.println(" 총 객체수: " + set.size());

    iterator = set.iterator();
    while (iterator.hasNext()) {
      String element = iterator.next();
      System.out.println("\t" + element);
    }
    
    set.clear(); // 모든 객체를 제거하고 비운다.
    if (set.isEmpty()) {
      System.out.println("비어 있음");
    }
  }

}
