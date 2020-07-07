package io.wisoft.java_seminar.chap15.sec03.hashcode_equals;

public class Member {

  public String name;
  public int age;

  public Member(String name, int age) {
    this.age = age;
    this.name = name;
  }

  @Override
  public int hashCode() {
    return name.hashCode() + age;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Member) {
      Member member = (Member) obj;
      return member.name.equals(this.name) && (member.age == this.age);
    } else {
      return false;
    }
  }

}
