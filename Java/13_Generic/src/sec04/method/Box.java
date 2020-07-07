package io.wisoft.java_seminar.chap13.sec04.method;

public class Box<T> {
  private T t;

  public T get() {
    return t;
  }

  public void set(T t) {
    this.t = t;
  }
}
