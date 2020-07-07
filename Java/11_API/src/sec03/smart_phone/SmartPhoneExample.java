package io.wisoft.java_seminar.chap11.sec03.smart_phone;

public class SmartPhoneExample {

  public static void main(String[] args) {
    SmartPhone myPhone = new SmartPhone("구글", "안드로이드");

    String strObj = myPhone.toString();
    System.out.println(strObj);

    System.out.println(myPhone); // myPhone.toString() 자동호출
  }

}
