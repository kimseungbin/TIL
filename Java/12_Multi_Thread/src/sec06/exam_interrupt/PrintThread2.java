package io.wisoft.java_seminar.chap12.sec06.exam_interrupt;

public class PrintThread2 extends Thread {

  @Override
  public void run() {
//    try {
      while (true) {
        System.out.println("실행 중");
        if (Thread.interrupted()) {
          break; // while문을 빠져나옴
        }
//        Thread.sleep(1); // InterruptedException 발생가능
      }
//    } catch (InterruptedException e) { }

    System.out.println("자원 정리");
    System.out.println("실행 종료");
  }

}
