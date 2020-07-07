package io.wisoft.java_seminar.chap08.sec03.exam_implements_seminar;

public class MyClass {
  // 필드
  RemoteControl rc = new Television();

  // 생성자
  MyClass() {
  }

  MyClass(RemoteControl rc) {
    this.rc = rc;
    rc.turnOn();
    rc.setVolume(5);
  }

  // 메소드
  void methodA() {
    RemoteControl rc = new Audio();
    rc.turnOn();  // Audio의 turnOn()이 실행
    rc.setVolume(5);  // Audio의 setVolume(5)가 실행
  }

  void methodB(RemoteControl rc) {
    rc.turnOn();
    rc.setVolume(5);
  }
}
