package io.wisoft.java_seminar.chap11.sec03.equals;

public class Member {

  public String id;

  public Member(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Member) {  // 매개값이 Member 타입인지 확인
      Member member = (Member) obj;
      if (id.equals(member.id)) { // id필드값이 동일한지 검사
        return true;  // 동일하다면 true를 리턴
      }
    }
    return false; // 매개값이 Member 타입이 아니거나 id 필드값이 다른 경우 false리턴
  }

  @Override
  public int hashCode() {
    return id.hashCode(); // id가 동일한 문자열인 경우 같은 해시 코드를 리턴
  }

}
