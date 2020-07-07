package io.wisoft.java_seminar.chap12.sec06.exam_interrupt;

public class InterruptExample {

  public static void main(String[] args) {
    Thread thread = new PrintThread2();
    thread.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) { }

    thread.interrupt();
  }

}
