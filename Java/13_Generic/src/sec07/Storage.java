package io.wisoft.java_seminar.chap13.sec07;

public interface Storage<T> {
  public void add(T item, int index);
  public T get(int index);
}
