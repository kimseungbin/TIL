package io.wisoft.java_seminar.chap12.sec02.exam_beep_print2;

import java.awt.*;

public class BeepTask implements Runnable {

  public void run() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();  // Toolkit 객체 얻기
    for (int i = 0; i < 5; i++) {
      toolkit.beep(); // 비프음 발생
      try {
        Thread.sleep(500); // 0.5초 일시 정지
      } catch (Exception e) { }
    }
  }

}
