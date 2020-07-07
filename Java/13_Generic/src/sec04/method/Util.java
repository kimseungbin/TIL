package io.wisoft.java_seminar.chap13.sec04.method;

public class Util {

  public static <T> Box<T> boxing(T t) {
    Box<T> box = new Box<T>();
    box.set(t);
    return box;
  }

}
