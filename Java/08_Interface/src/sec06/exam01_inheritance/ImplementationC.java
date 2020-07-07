package io.wisoft.java_seminar.chap08.sec06.exam01_inheritance;

public class ImplementationC implements InterfaceC {
  @Override
  public void methodA() {
    System.out.println("ImplementationC-methodA() 실행");
  }

  @Override
  public void methodB() {
    System.out.println("ImplementationC-methodB() 실행");
  }

  @Override
  public void methodC() {
    System.out.println("ImplementationC-methodC() 실행");
  }
}
