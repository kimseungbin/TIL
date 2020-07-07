package io.wisoft.java_seminar.chap08.sec05.exam02_polymorphism;

public class Bus implements Vehicle {
  @Override
  public void run() {
    System.out.println("버스가 달립니다");
  }
}
