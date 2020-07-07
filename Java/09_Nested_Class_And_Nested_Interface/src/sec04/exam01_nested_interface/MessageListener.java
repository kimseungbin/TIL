package io.wisoft.java_seminar.chap09.sec04.exam01_nested_interface;

public class MessageListener implements Button.OnClickListener {

  @Override
  public void onClick() {
    System.out.println("메시지를 보냅니다.");
  }

}
