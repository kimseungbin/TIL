package io.wisoft.java_seminar.chap12.sec04.exam_calc;

public class Calculator {

  private int memory;

  public int getMemory() {
    return memory;
  }

  public void setMemory(int memory) {
    synchronized (this) { // 잠금대상: 공유 객체인 Calculator
      this.memory = memory;
      try {
        Thread.sleep(2000); // 스레드를 2초간 일시 정지
      } catch (Exception e) { }
      System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }
  }

}
