package io.wisoft.java_seminar.chap08.sec03.exam_implements_seminar;

public class Television implements RemoteControl {
  // 필드
  private int volume;

  // turnOn() 추상 메소드의 실체 메소드
  @Override
  public void turnOn() {
    System.out.println("TV를 켭니다.");
  }

  // turnOff() 추상 메소드의 실체 메소드
  @Override
  public void turnOff() {
    System.out.println("TV를 끕니다.");
  }

  // setVolume() 추상 메소드의 실체 메소드
  @Override
  public void setVolume(int volume) {	// 인터페이스 상수를 이용해서 volume 필드의 값을 제한
    if (volume > RemoteControl.MAX_VOLUME) {
      this.volume = RemoteControl.MAX_VOLUME;
    } else if (volume < RemoteControl.MIN_VOLUME) {
      this.volume = RemoteControl.MIN_VOLUME;
    } else {
      this.volume = volume;
    }
    System.out.println("현재 TV 볼륨: " + this.volume);
  }
}