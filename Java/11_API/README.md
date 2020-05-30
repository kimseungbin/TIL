# 기본 API 클래스

## 자바 API 도큐먼트

- <b>API(Application Programming Interface)</b>
  - 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음
  - 라이브러리(library)라고 부르기도 한다.
  - String 클래스와 System 클래스도 모두 API에 속하는 클래스
  - <JDK 설치 경로> \ jre \ lib \ rt.jar 이라는 압축파일에 저장되어 있다.
- <b>API 도큐먼트</b>
  - 쉽게 API를 찾아 이용할 수 있도록 문서화한 것
  - HTML페이지로 작성되어 있다.
  - [버전별 보기](https://docs.oracle.com/en/java/javase/index.html)
- JDK 8과 JDK 11의 도큐먼트 레이아웃이 다르다.
  - JDK 8은 전체 자바 표준 API를 패키지별로 정리하여 보여줌
  - JDK 11 이후 버전은 전체 자바 표준 API를 모듈별로 구분해서 정리함
- JDK 8 API 도큐먼트에서 String 클래스를 찾는법
  - 왼쪽 상단 Packages 목록에서 java.lang 패키지 링크를 찾아 클릭
    - 왼쪽 하단에 java.lang 패키지의 내용이 나옴
  - Classes 목록에서 String 클래스를 찾아 클릭
  - 오른쪽에 Class String 페이지가 나옴
- JDK 11 이후 버전 API 도큐먼트에서 String 클래스를 찾는법
  - 방법 1
    - All Modules 목록에서 java.base 링크를 찾아 클릭
    - java.base 모듈 페이지의 Package 목록에서 java.lang 패키지 링크를 찾아 클릭
    - java.lang 패키지 페이지의 Class Summary 목록에서 String 클래스 링크를 찾아 클릭
  - 방법 2
    - 오른쪽 상단의 Search 검색란에 "String"을 입력
    - 드롭다운 목록에서 java.lang.String 항목을 선택

## 클래스 페이지 읽는법

![](./img/API_doc_read.PNG)

- 페이지 상단 부분
  - 클래스가 포함된 패키지 정보
  - 상속 정보
  - 인터페이스 구현 정보를 표시
- 페이지 중앙 부분
  - 클래스의 설명과 사용 방법을 간략하게 보여준다.

![](./img/field.PNG)

- 필드목록
  - static 또는 protected 여부와 타입
  - 필드 이름 클릭시 상세 설명 페이지로 이동

![](./img/constructor.PNG)

- 생성자 목록
  - 생성자 이름과 매개 변수의 타입
  - 간단한 설명
  - 생성자 이름 클릭시 상세 설명 페이지로 이동

![](./img/method.PNG)

- 메소드 목록
  - 메소드의 접근제한자와 리턴타입
  - 메소드 이름과 매개 변수에 대한 정보
  - 메소드 이름 클릭시 상세 설명 페이지로 이동

![](./img/move.PNG)

- 클래스가 가지고 있는 중첩 클래스, 필드, 생성자, 메소드의 목록으로 바로 가고 싶다면?
  - 최상단의 SUMMARY: NESTED | FIELD | CONSTR | METHOD 링크를 바로 클릭

## java.lang과 java.util 패키지

- 공통적으로 가장 많이 사용하는 패키지
  - java.lang 패키지
  - java.util 패키지
  - java.time 패키지

### java.lang 패키지

- java.lang 패키지
  - 자바 프로그램의 기본적인 클래스를 담고 있는 패키지
  - java.lang 패키지에 있는 클래스와 인터페이스는 import 없이 사용할 수 있다.
- 주요 클래스

![](./img/java_lang_table.PNG)

### java.util 패키지

- java.util 패키지
  - 자바 프로그램 개발에 조미료 같은 역할을 하는 클래스를 담고 있다.
  - 컬렉션 클래스들이 대부분 차지
- 주요 클래스

![](./img/java_util_table.PNG)

##  Object 클래스

- 클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 lang.Object 클래스를 상속
  - 자바의 모든 클래스는 Object 클래스의 자식이거나 자손 클래스이다.
  - Object는 자바의 최상위 부모 클래스에 해당

![](./img/Object.PNG)

![](./img/Class_Object.PNG)

- Object 클래스는 필드가 없고, 메소드들로 구성됨
  - 모든 클래스가 Object를 상속하기 때문에 이 메소드들은 모든 클래스에서 사용이 가능

### 객체 비교(equals())

```java
// Object의 equals() 메소드
public boolean equals(Object obj) { ... }
```

- equals() 메소드의 매개 타입은 Object
  - 모든 객체가 매개값으로 대입될 수 있음을 말함
  - Object가 최상위 타입이므로 모든 객체는 Object 타입으로 자동 타입 변환될 수 있다.
- 비교 연산자(==)와 동일한 결과를 리턴
- 두 객체가 동일한 객체라면 true를 리턴, 그렇지 않으면 false를 리턴

```java
Object obj1 = new Object();
Object obj2 = new Object();

boolean result = obj1.equals(obj2); // obj1 : 기준객체 | obj2 : 비교 객체
boolean result = (obj1 == obj2)	// 위와 결과가 동일(false)
```

- 두 객체를 동등 비교할 때 equals() 메소드를 사용
  - 두 객체를 비교해서 논리적으로 동등하면 true리턴, 그렇지 않으면 false리턴
- 논리적으로 동등하다?
  - 같은 객체이건 다른 객체이건 상관없이 객체가 저장하고 있는 데이터가 동일함을 뜻함
  - ex) String 객체의 equals() 메소드
    - String 객체의 번지 비교가 아니고, 문자열이 동일한지 조사해서 같다면 true를, 그렇지 않다면 false를 리턴
    - String 클래스가 Object의 equals() 메소드를 재정의(오버라이딩)해서 번지 비교가 아닌 문자열 비교로 변경했기 때문에 가능
- Object의 equals() 메소드는 직접 사용되지 않는다.
  - 하위 클래스에서 재정의하여 논리적으로 동등 비교할 때 이용됨
  - ex) Member 객체는 다르지만 id 필드값이 같으면 논리적으로 동등한 객체로 취급하고 싶을 경우  
    Object의 equlas() 메소드를 재정의해서 id 필드값이 같음을 비교
- equals() 메소드를 재정의 할 때
  - 매개값(비교 객체)이 기준 객체와 동일한 타입의 객체인지 확인해야 한다.
    - Object 타입의 매개 변수는 모든 객체가 매개값으로 제공될 수 있다.
  - instanceof 연산자로 기준 객체와 동일한 타입인지 확인해야 함
    - 다른 타입이라면 false를 리턴해야 한다.
    - 같은 타입이라면 기준 객체 타입으로 강제 타입 변환해서 필드값이 동일한지 검사
      - 필드값이 모두 동일하다면 true, 그렇지 않으면 false를 리턴하도록 작성

```java
// Member 클래스에서 equals() 메소드를 재정의
// Member 타입이면서 id 필드값이 같을 경우 true를 리턴
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
  
}
```

```java
// 실행 클래스
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
```

![](./img/equals.PNG)

### 객체 해시코드(hashCode())

- <b>객체 해시코드란?</b>
  - 객체를 식별할 하나의 정수값
- Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해서 해시코드를 만들어 리턴한다.
  - 때문에 객체마다 다른 값을 가지고 있다.
- 논리적 동등 비교 시 hashCode()를 오버라이딩할 필요성이 있다.
  - 컬렉션 프레임워크에서 HashSet, HashMap, Hashtable은 아래처럼 방법으로 두 객체가 동등한지 비교
    - 우선 hashCode() 메소드를 실행해 리턴된 해시코드 값이 같은지 본다.
    - 해시코드 값이 다르면 다른 객체로 판단
    - 해시코드 값이 같으면 equals() 메소드로 다시 비교
    - 때문에 hashCode() 메소드가 true가 나와도 equals()의 리턴값이 다르면 다른 객체가 됨

![](./img/hashCode.PNG)

- 아래 예제의 Key 클래스는 equals() 메소드를 재정의해서 number 필드값이 같으면 true를 리턴
  - 하지만 hashCode() 메소드는 재정의하지 않았기 때문에 Object의 hashCode() 사용

```java
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
  
}
// 결과는 null이 나옴
```

- 위와 같은 경우 HashMap의 식별키로 Key 객체를 사용하면 저장된 값을 찾아오지 못함
  - number 필드값이 같더라도 hashCode() 메소드에서 리턴하는 해시코드가 다르기 때문
    - 다른 식별키로 인식한다.

```java
// "new Key(1)" 객체로 "홍길동"을 저장하고
// 다시 "new Key(1)" 객체로 저장된 "홍길동"을 읽으려고 하는 예제
import java.util.HashMap;

public class KeyExample {

  public static void main(String[] args) {
    // Key 객체를 식별키로 사용해 String 값을 저장하는 HashMap 객체 생성
    HashMap<Key, String> hashMap = new HashMap<Key, String>();

    // 식별키 "new Key(1)" 로 "홍길동" 을 저장
    hashMap.put(new Key(1), "홍길동");

    // 식별키 "new Key(1)" 로 "홍길동" 을 읽어옴
    String value = hashMap.get(new Key(1));
    System.out.println(value);
  }

}
```

- 의도한 "홍길동"을 읽기 위해서 hashCode() 메소드를 Key 클래스에 추가하면 된다.

```java
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
  // hashCode()의 리턴값을 number 필드값으로 함
  // 때문에 저장할 때의 "new Key(1)"과 읽을 때의 "new Key(1)"은 같은 해시코드가 리턴됨
    
}
```

- 저장할 때의 `new Key(1)`과 읽을 때의 `new Key(1)`은 서로 다른 객체
  - 하지만 위 예제처럼 오버라이딩 시 HashMap은 `hashCode()`의 리턴값이 같고, `equals()` 리턴값이 true가 나오기 때문에 동등 객체로 평가
    - 즉, 같은 식별키로 인식함
- 결론
  - 객체의 동등 비교를 위해서는 Object의 equals() 뿐만아니라 hashCode() 메소드도 재정의해서 논리적 동등 객체일 경우 동일한 해시코드가 리턴되도록 해야 한다.

```java
// 위쪽에서 사용한 Member 클래스를 보완
// 추가로 hashCode() 메소드도 재정의
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
    return id.hashCode(); // id가 동일한 문자열인 경우 같은 해시 코드를 리턴함
  }

}
```

### 객체 문자 정보(toString())

- Object 클래스의 toString() 메소드
  - 객체의 문자 정보를 리턴
  - 기본적으로 "클래스명@16진수해시코드"로 구성된 문자 정보를 리턴
- 객체의 문자 정보란?
  - 객체를 문자열로 표현한 값

```java
// 기본적인 toString() 메소드는 "클래스명@16진수해시코드"로 구성된 문자정보 리턴
Object obj = new Object();
System.out.println( obj.toString() );
```

- Object 클래스의 toString() 메소드의 기본 리턴값은 값어치가 별로 없는 정보
  - Object 하위 클래스는 toString() 메소드를 재정의(오버라이딩)하여 간결하고 유익한 정보를 리턴
  - ex1 ) java.util 패키지의 Date 클래스는 toString() 메소드를 재정의하여 현재 시스템의 날짜와 시간 정보를 리턴
  - ex2 ) String 클래스는 toString() 메소드를 재정의하여 저장하고 있는 문자열을 리턴

```java
// Object 클래스와 Date 클래스의 toString() 메소드의 리턴값을 출력하는 예
import java.util.Date;

public class ToStringExample {

  public static void main(String[] args) {
    Object obj1 = new Object();
    Date obj2 = new Date();
    System.out.println(obj1.toString());
    System.out.println(obj2.toString());
  }

}
```

![](./img/toString.PNG)

- 직접 만드는 클래스도 toString() 메소드를 재정의하여 좀 더 유용한 정보를 리턴하도록 할 수 있다.

```java
// SmartPhone 클래스에서 toString() 메소드를 오버라이딩하여 제작회사와 운영체제를 리턴
public class SmartPhone {
  
  private String company;
  private String os;

  public SmartPhone(String company, String os) {
    this.company = company;
    this.os = os;
  }

  @Override
  public String toString() { // toString() 재정의
    return company + ", " + os;
  }
  
}
```

```java
// 실행 클래스
public class SmartPhoneExample {

  public static void main(String[] args) {
    SmartPhone myPhone = new SmartPhone("구글", "안드로이드");

    String strObj = myPhone.toString();
    System.out.println(strObj);

    System.out.println(myPhone); // myPhone.toString() 자동호출
  }

}
```

![](./img/toString_smartPhone.PNG)

- System.out.println() 메소드
  - 매개값이 기본타입일 경우, 해당 값을 그대로 출력
  - 매개값이 객체일 경우 객체의 toString() 메소드를 호출해서 리턴값을 받아 출력

### 객체 복제(clone())

- 객체 복제
  - 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것
- 객체를 복제하는 이유
  - 원본 객체를 안전하게 보호하기 위해
    - 신뢰하지 않는 영역으로 원본 객체를 넘길경우 원본 객체의 데이터가 훼손될 수 있다.
    - 신뢰하지 않는 영역으로 복제된 객체를 넘기는 것이 좋다.
    - 복제된 객체의 데이터가 훼손되더라도 원본 객체는 아무런 영향을 받지 않는다.
  - 안전하게 데이터를 보호할 수 있게 됨
- 객체를 복제하는 방법
  - 얕은 복제
  - 깊은 복제

#### 얕은 복제(thin clone)

- 얕은 복제(thin clone)란?
  - 단순히 필드값을 복사해서 객체를 복제하는 것
  - 필드값만 복제하기 때문에 필드가 기본 타입일 경우 값 복사
    - 참조 타입일 경우 객체의 번지가 복사
- ex) 원본 객체에 int타입 필드와 배열 타입 필드가 있을 경우의 얕은 복제된 객체의 필드값

![](./img/thin_clone.PNG)

- Object의 clone() 메소드는 자신과 동일한 필드값을 가진 얕은 복제된 객체를 리턴
- clone() 메소드로 객체를 복제하려면 원본 객체는 반드시 java.lang.Cloneable 인터페이스를 구현해야한다.
  - 클래스 설계자가 복제를 허용한다는 의도적인 표시를 하기 위해서
- 클래스 설계자가 복제를 허용하지 않는다면 Cloneable 인터페이스를 구현하지 않으면 된다.
  - 구현하지 않으면 clone() 메소드를 호출할 때 CloneNotSupportedException 예외 발생
  - clone() 메소드는 CloneNotSupportedException 예외 처리가 필요한 메소드
    - try-catch 구문이 필요

```java
try {
    Object obj = clone();
} catch (CloneNotSupportedException e) { }
```

- 예제

```java
// Member 클래스가 Cloneable 인터페이스를 구현
// 때문에 getMember() 메소드에서 clone() 메소드로 자신을 복제하여 외부로 리턴할 수 있다.
public class Member implements Cloneable {
  public String id;
  public String name;
  public String password;
  public int age;
  public boolean adult;

  public Member(String id, String name, String password, int age, boolean adult) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.age = age;
    this.adult = adult;
  }

  public Member getMemeber() {
    Member cloned = null;
    try {
      cloned = (Member) clone(); // clone() 메소드의 리턴 타입은 Object
        						 // Member 타입으로 캐스팅이 필요
    } catch (CloneNotSupportedException e) { }
    return cloned;
  }

}
```

```java
// 실행 클래스
  public static void main(String[] args) {
    // 원본 객체 생성
    Member original = new Member("blue", "홍길동", "12345", 25, true);

    // 복제 객체를 얻은 후에 패스워드 변경
    Member cloned = original.getMemeber();
    cloned.password = "67890"; // 복제 객체에서 패스워드 변경

    System.out.println("[복제 객체의 필드값]");
    System.out.println("id: " + cloned.id);
    System.out.println("name: " + cloned.name);
    System.out.println("password: " + cloned.password);
    System.out.println("age: " + cloned.age);
    System.out.println("adult: " + cloned.adult);

    System.out.println();

    System.out.println("[원본 객체의 필드값]");
    System.out.println("id: " + original.id);
    System.out.println("name: " + original.name);
    System.out.println("password: " + original.password); // 변함없음
    System.out.println("age: " + original.age);
    System.out.println("adult: " + original.adult);
  }

}
```

![](./img/memberClone.PNG)

#### 깊은 복제(deep clone)

- 얕은 복제(thin clone)의 경우 참조 타입 필드는 번지만 복제됨
  - 원본 객체의 필드와 복제 객체의 필드는 같은 객체를 참조하게 됨
  - 복제 객체에서 참조 객체 변경시 원본 객체도 변경된 객체를 가지게 됨(얕은 복제의 단점)
- 깊은 복제(deep clone)
  - 얕은 복제의 반대
  - 참조하고 있는 객체도 복제한다.
- ex) 원본 객체를 깊은 복제했을 경우

![](./img/deep_clone.PNG)

- 깊은 복제를 하려면?
  - Object의 clone() 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 작성
- 예제

```java
public class Member implements Cloneable {

  public String name;
  public int age;
  public int[] scores; // 참조 타입 필드(깊은 복제의 대상)
  public Car car; // 참조 타입 필드(깊은 복제의 대상)

  public Member(String name, int age, int[] scores, Car car) {
    this.name = name;
    this.age = age;
    this.scores = scores;
    this.car = car;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    // 얕은 복사를 해서 name, age를 복제
    Member cloned = (Member) super.clone();
    // scores를 깊은 복제
    cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
    // car를 깊은 복제
    cloned.car = new Car(this.car.model);
    // 깊은 복제된 Member 객체를 리턴
    return cloned;
  }

  public Member getMember() {
    Member cloned = null;
    try {
      cloned = (Member) clone(); // 재정의된 clone() 메소드 호출
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return cloned;
  }
  
}
```

```java
// Car 클래스
public class Car {

  public String model;

  public Car(String model) {
    this.model = model;
  }

}
```

```java
// 실행 클래스
public class MemberExample {

  public static void main(String[] args) {
    // 원본 객체 생성
    Member original = new Member("홍길동", 25, new int[]{90, 90}, new Car("소나타"));

    // 복제 객체를 얻은 후 참조 객체의 값 변경
    Member cloned = original.getMember();
    cloned.scores[0] = 100;
    cloned.car.model = "그랜저";

    System.out.println("[복제 객체의 필드값]");
    System.out.println("name: " + cloned.name);
    System.out.println("age: " + cloned.age);
    System.out.print("scores: {");
    for (int i = 0; i < cloned.scores.length; i++) {
      System.out.print(cloned.scores[i]);
      System.out.print((i == (cloned.scores.length - 1)) ? "" : ",");
        										// 마지막 원소면 ',' 미출력
    }
    System.out.println("}");
    System.out.println("car: " + cloned.car.model);

    System.out.println();

    System.out.println("[원본 객체의 필드값]");
    System.out.println("name: " + original.name);
    System.out.println("age: " + original.age);
    System.out.print("scores: {");
    for (int i = 0; i < original.scores.length; i++) {
      System.out.print(original.scores[i]);
      System.out.print((i == (original.scores.length - 1)) ? "" : ",");
        										// 마지막 원소면 ',' 미출력
    }
    System.out.println("}");
    System.out.println("car: " + original.car.model);
  }

}
// 깊은 복제 후 복제본을 변경해도 원본에 영향을 미치지 않음
```

![](./img/MemberExample.PNG)

### 객체 소멸자(finalize())

- 문제가 있어 자바9부터 <b>Deprecated</b>됨
  - Deprecated : 예전 자바 버전에서는 사용되었으나, 현재 버전과 차후 버전에서는 사용하지 말라는 뜻
- 오류/시점/성능/수행성 모두 보장하지 못함