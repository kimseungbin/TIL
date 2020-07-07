package io.wisoft.java_seminar.chap08.sec03.exam_implements;

public class RemoteControlExample {

  public static void main(String[] args) {

    RemoteControl rc = null;

    rc = new Television();
    rc.turnOn();
    rc.setMute(true);

    rc = new Audio();
    rc.turnOn();
    rc.setMute(true);

    RemoteControl.changeBattery();
  }

}
