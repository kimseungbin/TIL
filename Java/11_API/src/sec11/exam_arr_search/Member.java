package io.wisoft.java_seminar.chap11.sec11.exam_arr_search;

public class Member implements Comparable<Member> {
  String name;
  Member(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Member o) {
    return name.compareTo(o.name);
  }
}
