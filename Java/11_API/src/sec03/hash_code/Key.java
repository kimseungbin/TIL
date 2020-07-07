package io.wisoft.java_seminar.chap11.sec03.hash_code;

public class Key {

  public int number;

  public Key(int number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Key) {
      Key compareKey = (Key) obj;
      if (this.number == compareKey.number) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    return number;
  }

}
