package io.wisoft.java_seminar.chap12.sec06.exam_wait;

public class WaitNotifyExample {

  public static void main(String[] args) {
    WorkObject sharedObject = new WorkObject(); // 공유 객체 생성

    // ThreadA와 ThreadB 생성
    ThreadA threadA = new ThreadA(sharedObject);
    ThreadB threadB = new ThreadB(sharedObject);

    // ThreadA와 ThreadB를 실행
    threadA.start();
    threadB.start();
  }

}
