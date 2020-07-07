package io.wisoft.java_seminar.chap11.sec03.finalize;

public class FinalizeExample {

  public static void main(String[] args) {
    Counter coutner = null;
    for (int i = 1; i <= 50; i++) {
      coutner = new Counter(i);

      coutner = null;

      System.gc();
    }
  }

}
