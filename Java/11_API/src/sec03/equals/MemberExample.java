package io.wisoft.java_seminar.chap11.sec03.equals;

public class MemberExample {

  public static void main(String[] args) {
    Member obj1 = new Member("blue");
    Member obj2 = new Member("blue");
    Member obj3 = new Member("red");

    if (obj1.equals(obj2)) { // 매개값과 id 필드값이 동일하므로 true
      System.out.println("obj1과 obj2는 동등합니다.");
    } else {
      System.out.println("obj1과 obj2는 동등하지 않습니다.");
    }

    if (obj1.equals(obj3)) { // 매개값은 Member로 같지만, id 필드값이 다르므로 false
      System.out.println("obj1과 obj3은 동등합니다.");
    } else {
      System.out.println("obj1과 obj3은 동등하지 않습니다.");
    }
  }

}
