package io.wisoft.java_seminar.chap15.sec05.comparator;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {

  public static void main(String[] args) {
    /*
    TreeSet<Fruit> treeSet = new TreeSet<>();
    // Fruit이 Comparable을 구현하지 않아 예외 발생
    treeSet.add(new Fruit("포도", 3000));
    treeSet.add(new Fruit("수박", 10000));
    treeSet.add(new Fruit("딸기", 6000));
    */

    TreeSet<Fruit> treeSet = new TreeSet<>(new DescendingComparator());
    // 저장될 때 가격을 기준으로 내림차순 정렬된다.
    treeSet.add(new Fruit("포도", 3000));
    treeSet.add(new Fruit("수박", 10000));
    treeSet.add(new Fruit("딸기", 6000));

    Iterator<Fruit> iterator = treeSet.iterator();
    while (iterator.hasNext()) {
      Fruit fruit = iterator.next();
      System.out.println(fruit.name + ":" + fruit.price);
    }
  }

}
