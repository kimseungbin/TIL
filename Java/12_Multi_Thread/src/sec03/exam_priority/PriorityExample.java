package io.wisoft.java_seminar.chap12.sec03.exam_priority;

public class PriorityExample {

  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      Thread thread = new CalcThread("thread" + i);
      if (i != 10) { // Thread1~9는 우선순위를 가장 낮게 준다.
        thread.setPriority(Thread.MIN_PRIORITY); // 가장 낮은 우선순위 설정
      } else {
        thread.setPriority(Thread.MAX_PRIORITY); // 가장 높은 우선순위 설정
      }
      thread.start();
    }
  }

}
