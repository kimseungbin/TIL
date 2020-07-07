package io.wisoft.java_seminar.chap15.sec05.comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExample {

  public static void main(String[] args) {
    TreeSet<Person> treeSet = new TreeSet<>();

    // 저장될 때 나이순 정렬
    treeSet.add(new Person("홍길동", 45));
    treeSet.add(new Person("김자바", 25));
    treeSet.add(new Person("김승빈", 24));

    // 오름차순으로 가져오기
    Iterator<Person> iterator = treeSet.iterator();
    while (iterator.hasNext()) {
      Person person = iterator.next();
      System.out.println(person.name + ":" + person.age);
    }
  }

}
