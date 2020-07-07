package io.wisoft.java_seminar.chap11.sec03.deep_clone;

import java.util.Arrays;

public class Member implements Cloneable {

  public String name;
  public int age;
  public int[] scores; // 참조 타입 필드(깊은 복제의 대상)
  public Car car; // 참조 타입 필드(깊은 복제의 대상)

  public Member(String name, int age, int[] scores, Car car) {
    this.name = name;
    this.age = age;
    this.scores = scores;
    this.car = car;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    // 얕은 복사를 해서 name, age를 복제
    Member cloned = (Member) super.clone();
    // scores를 깊은 복제
    cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
    // car를 깊은 복제
    cloned.car = new Car(this.car.model);
    // 깊은 복제된 Member 객체를 리턴
    return cloned;
  }

  public Member getMember() {
    Member cloned = null;
    try {
      cloned = (Member) clone(); // 재정의된 clone() 메소드 호출
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return cloned;
  }

}
