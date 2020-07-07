package io.wisoft.java_seminar.chap12.sec06.exam_sleep;

import java.awt.*;

public class SleepExample {

  public static void main(String[] args) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    for (int i = 0; i < 10; i++) {
      toolkit.beep();
      try {
        Thread.sleep(3000); // 메인스레드를 3초동안 일시 정지 상태로 보낸다.
      } catch (InterruptedException e) {
      }
    }
  }

}
