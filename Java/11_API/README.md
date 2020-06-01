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

## Objects 클래스

- Object와 유사한 java.util.Objects 클래스
  - 객체 비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성된 Object의 유틸리티 클래스
- Objects 클래스가 가지고 있는 정적 메소드들

![](./img/Objects.PNG)

### 객체 비교(compare(T a, T b, comparator\<T>c))

- Objects.compare(T a, T b, Comparator\<T>c) 메소드
  - 두 객체를 비교자(Comparator)로 비교해서 int 값을 리턴
- java.util.Comparator\<T>
  - 제네릭 인터페이스 타입으로 두 객체를 비교하는 Compare(T a, T b) 메소드가 정의되어 있음
  - compare() 메소드의 리턴 타입은 int
    - a가 b보다 작으면 음수, 같으면 0, 크면 양수를 리턴하도록 구현 클래스를 만들어야 한다.

```java
public interface Comparator<T> {
    int compare(T a, T b);
}
```

```java
// 학생 객체에서 학생 번호로 비교하는 StudentComparator 구현 클래스
public class StudentComparator implements Comparator<Student> {
  @Override
  public int compare(Student a, Student b) {
    if (a.sno < b.sno) return -1;
    else if (a.sno == b.sno) return 0;
    else return 1;
    // return Integer.compare(a.sno, b.sno); 으로 대체가능
  }
}
```

- 세 개의 학생 객체를 StudentComparator로 비교해서 결과를 리턴하는 예제

```java
public class CompareExample {

  public static void main(String[] args) {
    Student s1 = new Student(1);
    Student s2 = new Student(1);
    Student s3 = new Student(2);

    int result = Objects.compare(s1, s2, new StudentComparator());
    System.out.println(result);
    result = Objects.compare(s1, s3, new StudentComparator());
    System.out.println(result);
  }

  static class Student {
    int sno;

    Student(int sno) {
      this.sno = sno;
    }
  }

  static class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
      /*if (o1.sno < o2.sno) return -1;
      else if(o1.sno == o2.sno) return 0;
      else return -1;*/
      return Integer.compare(o1.sno, o2.sno);
    }
  }

}
```

![](./img/CompareExample.PNG)

### 동등 비교(equals()와 deepEquals())

- Objects.equals(Object a, Object b)는 두 객체의 동등을 비교
  - 아래 표와같은 결과를 리턴
  - 특이한 점으로, a와 b가 모두 null일 경우 true를 리턴
  - a와 b가 null이 아닌 경우 a.equals(b)의 결과를 리턴

![](./img/ObjectsEquals.PNG)

- Objects.deepEqulas(Object a, Object b)역시 두 객체의 동등을 비교
  - a와 b가 서로 다른 배열일 경우
    - 항목 값이 모두 같다면 true를 리턴
  - Arrays.deepEquals(Object[] a, Object[] b)와 동일

![](./img/deepEquals.PNG)

```java
import java.util.Arrays;
import java.util.Objects;

public class EqualsAndDeepEqualsExample {

  public static void main(String[] args) {
    Integer o1 = 1000;
    Integer o2 = 1000;
    System.out.println(Objects.equals(o1, o2));
    System.out.println(Objects.equals(o1, null));
    System.out.println(Objects.equals(null, o2));
    System.out.println(Objects.equals(null, null));
    System.out.println(Objects.deepEquals(o1, o2) + "\n");

    Integer[] arr1 = {1, 2};
    Integer[] arr2 = {1, 2};
    System.out.println(Objects.equals(arr1, arr2));
    System.out.println(Objects.deepEquals(arr1, arr2));
    System.out.println(Arrays.deepEquals(arr1, arr2));
    System.out.println(Objects.deepEquals(null, arr2));
    System.out.println(Objects.deepEquals(arr1, null));
    System.out.println(Objects.deepEquals(null, null));
  }

}
```

![](./img/EqAndDeqEx.PNG)

### 해시코드 생성(hash(), hashCode())

- Objects.hash(Object... values) 메소드
  - 매개값으로 주어진 값들을 이용해 해시코드를 생성하는 역할을 함
  - 주어진 매개값들로 배열을 생성하고 Arrays.hashCode(Object[])를 호출해서 해시코드를 얻는다.
    - 이 값을 리턴
  - 클래스가 hashCode()를 재정의할 때 리턴값을 생성하기 위해 사용하면 좋다.
  - 클래스가 여러 필드를 가지고 있을 때 이 필드들로부터 해시 코드를 생성하게 된다면
    - 동일한 필드값을 가지는 객체는 동일한 해시코드를 가질 수 있다.

```java
@Override
public int hashCode() { // hashCode()재정의
    return Objects.hash(field1, field2, field3);
}
```

- Objects.hashCode(Object o)는 매개값으로 주어진 객체의 해시코드를 리턴한다.
  - 때문에 o.hashCode()의 리턴값과 동일하다.
  - 차이점은 매개값이 null이면 0을 리턴

```java
// Student 객체의 해시코드를 생성하기 위해 Student의 필드인
// sno와 name을 매개값으로 해서 Objects.hash() 메소드를 호출.
import java.util.Objects;

public class HashCodeExample {

  public static void main(String[] args) {
    Student s1 = new Student(1, "홍길동");
    Student s2 = new Student(1, "홍길동");
    System.out.println(s1.hashCode());
    System.out.println(Objects.hashCode(s2));
  }

  static class Student {
    int sno;
    String name;

    Student(int sno, String name) {
      this.sno = sno;
      this.name = name;
    }

    @Override
    public int hashCode() {
      return Objects.hash(sno, name);
      // 학생 번호와 이름이 동일하다면 같은 해시코드를 얻음
    }
  }

}
```

![](./img/HashCodeExample.PNG)

### 널 여부 조사(isNull(), nonNull(), requireNonNull())

- Objects.isNull(Object obj)
  - 매개값이 null일 경우 true를 리턴
- nonNull(Object obj)
  - 매개값이 not null일 경우 true를 리턴
- requireNonNull()은 아래의 세 가지로 오버로딩 되어 있음

![](./img/requireNonNull.PNG)

- 첫 번째 매개값이 not null이라면 첫 번째 매개값을 리턴
  - null 이면 모두 NullPointerException을 발생
- 두 번째 매개값은 NullPointerException의 예외 메시지를 제공

```java
import java.util.Objects;

public class NullExample {

  public static void main(String[] args) {
    String str1 = "홍길동";
    String str2 = null;

    System.out.println(Objects.requireNonNull(str1));


    try {
      String name = Objects.requireNonNull(str2);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      String name = Objects.requireNonNull(str2, "이름이 없습니다.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {										// 두 번째 매개값으로 람다식
      String name = Objects.requireNonNull(str2, () -> "이름이 없다니깐요");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
```

![](./img/NullExample.PNG)

### 객체 문자 정보(toString())

- Objects.toString()
  - 객체의 문자 정보를 리턴
  - 두 가지로 오버로딩 되어있다.

![](./img/ObjectsToString.PNG)

- 첫 번째 매개값이 not null 이면 toString()으로 얻은 값을 리턴
  - null 이면 "null" 또는 두 번째 매개값인 nullDefault를 리턴한다.

```java
import java.util.Objects;

public class ToStringExample {

  public static void main(String[] args) {
    String str1 = "홍길동";
    String str2 = null;

    System.out.println(Objects.toString(str1));
    System.out.println(Objects.toString(str2));
    System.out.println(Objects.toString(str2, "이름이 없습니다."));
  }

}
```

![](./img/ToStringExample.PNG)

## System 클래스

- 자바 프로그램은 운영체제상에서 바로 실행되는 것이 아니다.
  - JVM 위에서 실행된다.
- 따라서 운영체제의 모든 기능을 자바 코드로 직접 접근하기 어렵다.
  - 하지만 java.lang 패키지에 속하는 System 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다.
  - 즉, 프로그램 종료, 키보드로부터 입력, 모니터로 출력, 메모리 정리, 현재 시간 읽기, 시스템 프로퍼티 읽기, 환경 변수 읽기 등이 가능
- System 클래스의 모든 필드와 메소드는 정적(static) 필드와 정적(static) 메소드로 구성되어 있다.

### 프로그램 종료(exit())

- System 클래스의 exit() 메소드
  - 현재 실행되고 있는 프로세스를 강제 종료시키는 역할
- exit() 메소드는 int 매개값을 지정하도록 되어 있다.
  - 이 값을 종료 상태값이라고 한다.
  - 일반적으로 정상 종료일 경우 0으로 지정
    - 비정상 종료일 경우 0 이외의 다른 값을 준다.

```java
System.exit(0);
```

- 어떠한 값을 주더라도 종료가 된다.
  - 만약 특정 값이 입력되었을 경우에만 종료하고 싶다면?
    - 자바의 보안 관리자를 직접 설정해서 종료 상태값을 확인하면 된다.
- System.exit()가 실행되면 보안 관리자의 checkExit() 메소드가 자동 호출
  - 이 메소드에서 종료 상태값을 조사해서 특정 값이 입력되지 않으면  SecurityException을 발생시킴
    - System.exit()를 호출한 곳에서 예외 처리를 할 수 있도록 해준다.
- checkExit() 가 정상적으로 실행되면 JVM은 종료가 된다.

```java
// 종료 상태 값으로 5가 입력되면 JVM을 종료하도록 보안 관리자를 설정
System.setSecurityManager(new SecurityManager(){
    @Override
    public void checkExit(int status) {
        if (status != 5) {
            throw new SecurityException();
        }
    }
});
```

- 종료 상태값이 5일 경우에만 프로세스를 종료하는 예제

```java
public class ExitExample {

  public static void main(String[] args) {
    // 보안 관리자 설정
    System.setSecurityManager(new SecurityManager() {
      @Override
      public void checkExit(int status) {
        if (status != 5) {
          throw new SecurityException();
        }
      }
    });

    for (int i = 0; i < 10; i++) {
      // i값 출력
      System.out.println(i);
      try {
        // JVM 종료 요청
        System.exit(i);
      } catch (SecurityException e) { }
    }
  }

}
```

![](./img/ExitExample.PNG)

### 쓰레기 수집기 실행(gc())

- 자바는 JVM이 알아서 메모리를 자동으로 관리
  - JVM은 메모리가 부족할 때, CPU가 한가할 때 쓰레기 수집기 (Garbage Collector)를 실행
    - 사용하지 않는 객체를 자동 제거
- new 연산자로 Car 객체를 생성하고 변수 myCar에 객체 번지를 대입했다면?

```java
Car myCar = new Car();
```

![](./img/myCar.PNG)

- 만약 변수 myCar = null을 대입하면 myCar는 객체의 번지를 읽게된다.
  - 더 이상 Car 객체는 사용할 수가 없고, 쓰레기가 된다.

```java
myCar = null;
```

![](./img/myCar_null.PNG)

- 변수 myCar가 다른 Car 객체를 참조할 경우도 마찬가지
  - 이전 객체의 번지를 잃기 때문에 이전 객체는 쓰레기가 된다.

```java
Car myCar = new Car();	// 이전 참조 객체
myCar = new Car();		// 현재 참조 객체
```

![](./img/myCar_new.PNG)

- 쓰레기 수집기는 개발자가 직접 코드로 실행시킬 수 없다.
  - System.gc() 메소드로 JVM에게 가능한한 빨리 실행해 달라고 요청할 수는 있다.
- System.gc() 메소드가 호출되면 쓰레기 수집기가 바로 실행되는 것은 아니다.
  - JVM은 빠른 시간 내에 실행시키기 위해 노력한다.

```java
System.gc();
```

- 쓰레기가 생길 때마다 쓰레기 수집기가 동작한다면?
  - 수행되어야 할 프로그램의 속도가 떨어지기 때문에 성능 측면에서 좋지 않다.
  - 메모리가 충분하다면 굳이 쓰레기 수집기를 실행할 필요가 없다.
- gc() 메소드는 메모리가 열악하지 않은 환경이라면 거의 사용할 일이 없다.
- 쓰레기 수집기는 객체를 삭제하기 전에 마지막으로 객체의 [소멸자](#객체 소멸자(finalize())를 실행한다.

### 현재 시각 읽기(currentTimeMillis(), nano Time())

- System 클래스의 currentTimeMillis() 메소드와 nanoTime 메소드
  - 컴퓨터의 시계로부터 현재 시간을 읽어
    - 밀리세컨드(1/1000)초 단위와
    - 나노세컨드(1/10<sup>9</sup>초) 단위의 long 값을 리턴한다.

```java
long time = System.currentTimeMillis();
long time = System.nanoTime();
```

- 리턴값은 주로 프로그램의 실행 소요 시간 측정에 사용된다.
  - 프로그램 시작 시 시각을 읽고, 프로그램이 끝날 때 시각을 읽어 차이를 구하면 프로그램 실행 소요 시간

```java
// for문을 사용해서 1부터 1000000 까지의 합을 구하는데 걸린 시간출력 예제
public class SystemTimeExample {

  public static void main(String[] args) {
    long time1 = System.nanoTime(); // 시작 시간 읽기

    int sum = 0;
    for (int i = 1; i <= 1000000; i++) {
      sum += i;
    }

    long time2 = System.nanoTime(); // 끝 시간 읽기

    System.out.println("1~1000000까지의 합 : " + sum);
    System.out.println("계산에 " + (time2 - time1) + " 나노초가 소요됨");
  }

}
```

![](./img/nanoTime.PNG)

### 시스템 프로퍼티 읽기(getProperty())

- 시스템 프로퍼티(System Property)는 JVM이 시작할 때 자동 설정되는 시스템의 속성값을 말한다.
  - ex)
    - 운영체제의 종류 및 자바 프로그램을 실행시킨 사용자 아이디
    - JVM의 버전
    - 운영체제에서 사용되는 파일 경로 구분자 등
- 시스템 프로퍼티는 키(key)와 값(value)으로 구성되어 있다.
- (표)대표적인 키와 값

![](./img/getProperty.PNG)

- 시스템 프로퍼티를 읽어오기 위해 System.getProperty() 메소드를 이용
  - 시스템 프로퍼티의 키 이름을 매개값으로 받고, 해당 키에 대한 값을 문자열로 리턴한다.

```java
String value = System.getProperty(String key);
```

```java
// 운영체제 이름, 사용자 이름, 사용자 홈 디렉토리를 알아내고 출력하는 예제
// 또한 모든 시스템 프로퍼티를 키와 값으로 출력
import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

  public static void main(String[] args) {
    String osName = System.getProperty("os.name");
    String userName = System.getProperty("user.name");
    String userHome = System.getProperty("user.home");

    System.out.println("운영체제 이름: " + osName);
    System.out.println("사용자 이름: " + userName);
    System.out.println("사용자 홈디렉토리: " + userHome);

    System.out.println("----------------------------");
    System.out.println(" [ key ]  value ");
    System.out.println("----------------------------");
    Properties props = System.getProperties();
    Set keys = props.keySet();
    // Set객체로부터 키를 하나씩 얻어내어 문자열로 변환한 다음,
    // System.getProperty() 메소드로 값을 얻어 키와 값을 모두 출력
    for (Object objKey : keys) {
      String key = (String) objKey;
      String value = System.getProperty(key);
      System.out.println("[ " + key + " ]  " + value);
    }
  }

}
```

![](./img/GetPropertyExample.PNG)

- System.getProperties() 메소드
  - 모든 (키, 값) 쌍을 저장하고 있는 Properties 객체를 리턴한다.
  - 이 객체의 keySet() 메소드를 호출하면 키만으로 구성된 Set 객체를 얻을 수 있다.

### 환경 변수 읽기(getenv())

- 환경 변수(Environment Variable)
  - 대부분의 운영체제가 실행되는 프로그램들에게 유용한 정보를 제공할 목적으로 제공
  - 운영체제에서 이름(Name)과 값(Value)으로관리되는 문자열 정보
  - 운영체제가 설치될 때 기본적인 내용이 설정된다.
  - 사용자가 직접 설정하거나 응용 프로그램이 설치될 때 자동적으로 추가 설정되기도 한다.
- 자바는 환경 변수의 값이 필요할 경우 System.getenv() 메소드를 사용
  - 매개값으로 환경 변수 이름을 주면 값을 리턴한다.

```java
String value = System.getenv(String name);
```

- JAVA_HOME 환경 변수의 값을 얻어와서 출력하는 예제

```java
public class SystemEnvExample {

  public static void main(String[] args) {
    String javaHome = System.getenv("JAVA_HOME");
    System.out.println("JAVA_HOME: " + javaHome);
  }

}
```

![](./img/EnvExample.PNG)