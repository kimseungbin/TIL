package io.wisoft.java_seminar.chap12.sec03.exam_priority;

public class CalcThread extends Thread {

  public CalcThread(String name) {
    setName(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 2000000000; i++) {
    }
    System.out.println(getName());
  }

}
