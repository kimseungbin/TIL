package io.wisoft.java_seminar.chap09.sec04.exam01_nested_interface;

public class CallListener implements Button.OnClickListener {

  @Override
  public void onClick() {
    System.out.println("전화를 겁니다.");
  }

}
