package io.wisoft.java_seminar.chap07.sec08.exam01_abstract_class;

public class PhoneExample {

  public static void main(String[] args) {
    //Phone phone = new Phone();

    SmartPhone smartPhone = new SmartPhone("홍길동");

    smartPhone.turnOn();
    smartPhone.internetSearch();
    smartPhone.turnOff();
  }

}
