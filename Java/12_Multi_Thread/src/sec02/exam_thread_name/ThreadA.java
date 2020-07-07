package io.wisoft.java_seminar.chap12.sec02.exam_thread_name;

public class ThreadA extends Thread {
  
  public ThreadA() {
    setName("ThreadA"); // 스레드 이름 설정
  }

  @Override
  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.println(getName() + "가 출력한 내용");
    }
  }

}
