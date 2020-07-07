package io.wisoft.java_seminar.chap11.sec03.finalize;

public class Counter {

  private int no;

  public Counter(int no) {
    this.no = no;
  }
  
  @Override
  protected void finalize() throws Throwable {
    System.out.println(no + "번 객체의 finalize()가 실행됨");
  }

}
