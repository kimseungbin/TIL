package io.wisoft.java_seminar.chap13.sec05._extends;

public class BoundedTypeParameterExample {

  public static void main(String[] args) {
    // String str = Util.compare("a", "b"); (X) String은 Number 타입이 아니다.

    int result1 = Util.compare(10, 20); // 자동 Boxing
    System.out.println(result1);

    int result2 = Util.compare(4.5, 3); // 자동 Boxing
    System.out.println(result2);
  }

}
