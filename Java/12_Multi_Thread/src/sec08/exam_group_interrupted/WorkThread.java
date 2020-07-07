package io.wisoft.java_seminar.chap12.sec08.exam_group_interrupted;

public class WorkThread extends Thread {

  public WorkThread(ThreadGroup threadGroup, String threadName) {
    super(threadGroup, threadName);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(getName() + " Interrupted");
        break;
      }
    }
    System.out.println(getName() + " 종료됨");
  }
}
