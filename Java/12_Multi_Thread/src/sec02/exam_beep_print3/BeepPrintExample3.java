package io.wisoft.java_seminar.chap12.sec02.exam_beep_print3;

public class BeepPrintExample3 {

  public static void main(String[] args) {
    Thread thread = new BeepThread();
    thread.start();

    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        thread.sleep(500);
      } catch (Exception e) { }
    }
  }

}
