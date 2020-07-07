package io.wisoft.java_seminar.chap08.sec07.exam01_default_method;

public interface MyInterface {
  public void method1();
  
  public default void method2() {
    System.out.println("MyInterface-method2() 실행");
  }
}
