package io.wisoft.java_seminar.chap11.sec03.smart_phone;

public class SmartPhone {
  private String company;
  private String os;

  public SmartPhone(String company, String os) {
    this.company = company;
    this.os = os;
  }

  @Override
  public String toString() { // toString() 재정의
    return company + ", " + os;
  }
}
