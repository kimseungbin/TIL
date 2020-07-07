package io.wisoft.java_seminar.chap12.sec06.exam_join;

public class SumThread extends Thread {

  private long sum;

  public long getSum() {
    return sum;
  }

  public void setSum(long sum) {
    this.sum = sum;
  }

  public void run() {
    for (int i = 1; i <= 100; i++) {
      sum += i;
    }
  }

}
