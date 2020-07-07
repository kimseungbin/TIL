package io.wisoft.java_seminar.chap12.sec02.exam_beep_print2;

import java.awt.*;

public class BeepPrintExample2 {

  public static void main(String[] args) {

    Thread thread = new Thread(() -> {
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      for (int i = 0; i < 5; i++) {
        toolkit.beep();
        try {
          Thread.sleep(500);
        } catch (Exception e) { }
      }
    });

//    Thread thread = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        Toolkit toolkit = Toolkit.getDefaultToolkit();  // Toolkit 객체 얻기
//        for (int i = 0; i < 5; i++) {
//          toolkit.beep(); // 비프음 발생
//          try {
//            Thread.sleep(500); // 0.5초 일시 정지
//          } catch (Exception e) { }
//        }
//      }
//    });

//    Runnable beepTask = new BeepTask();
//    Thread thread = new Thread(beepTask);
    thread.start();

    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        Thread.sleep(500);
      } catch (Exception e) { }
    }
  }

}