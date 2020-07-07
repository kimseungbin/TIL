package io.wisoft.java_seminar.chap08.sec03.exam_implements_seminar;

public interface RemoteControl {
  // 상수
  public int MAX_VOLUME = 10;
  public int MIN_VOLUME = 0;

  // 추상 메소드
  public void turnOn();
  public void turnOff();
  public void setVolume(int volume);
}