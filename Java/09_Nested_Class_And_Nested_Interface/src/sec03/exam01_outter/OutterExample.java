package io.wisoft.java_seminar.chap09.sec03.exam01_outter;

public class OutterExample {

  public static void main(String[] args) {
    Outter outter = new Outter();
    Outter.Nested nested = outter.new Nested();
    nested.print();
  }

}
