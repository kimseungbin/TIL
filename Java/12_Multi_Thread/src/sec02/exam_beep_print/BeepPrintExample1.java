package io.wisoft.java_seminar.chap12.sec02.exam_beep_print;

import java.awt.*;

public class BeepPrintExample1 {

  public static void main(String[] args) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();  // Toolkit 객체 얻기
    for (int i = 0; i < 5; i++) {
      toolkit.beep(); // 비프음 발생
      try {
        Thread.sleep(500); // 0.5초 일시 정지
      } catch (Exception e) { }
    }

    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        Thread.sleep(500); // 0.5초 일시 정지
      } catch (Exception e) { }
    }
  }

}
