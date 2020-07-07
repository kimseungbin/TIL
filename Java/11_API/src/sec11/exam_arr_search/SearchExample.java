package io.wisoft.java_seminar.chap11.sec11.exam_arr_search;

import java.util.Arrays;

public class SearchExample {

  public static void main(String[] args) {
    // 기본 타입값 검색
    int[] scores = {99, 97, 98};
    Arrays.sort(scores);
    int index = Arrays.binarySearch(scores, 99);
    System.out.println("찾은 인덱스: " + index);

    // 문자열 검색
    String[] names = {"홍길동", "김승빈", "박자바"};
    Arrays.sort(names);
    index = Arrays.binarySearch(names, "홍길동");
    System.out.println("찾은 인덱스: " + index);

    // 객체 검색
    Member m1 = new Member("홍길동");
    Member m2 = new Member("김승빈");
    Member m3 = new Member("박자바");
    Member[] members = {m1, m2, m3};
    Arrays.sort(members);
    index = Arrays.binarySearch(members, m1);
    System.out.println("찾은 인덱스: " + index);
  }

}
