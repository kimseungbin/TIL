package io.wisoft.java_seminar.chap08.sec06.exam01_inheritance;

public class Example {

  public static void main(String[] args) {
    ImplementationC impl = new ImplementationC();

    InterfaceA ia = impl;
    ia.methodA();
    System.out.println();

    InterfaceB ib = impl;
    ib.methodB();
    System.out.println();

    InterfaceC ic = impl;
    ic.methodA();
    ic.methodB();
    ic.methodC();
  }

}
