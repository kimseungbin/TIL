# 멀티 스레드

## 멀티 스레드 개념

### 프로세스와 스레드

- 프로세스(process)
  - 운영체제에서는 실행 중인 하나의 애플리케이션을 프로세스(process)라고 부른다.
  - 사용자가 애플리케이션을 실행하면 운영체제로부터 실행에 필요한 메모리를 할당받아 애플리케이션의 코드를 실행한다.
  - 하나의 애플리케이션은 다중 프로세스를 만들기도 한다.
    - ex) Chrome 브라우저를 두 개 실행했다면 두 개의 Chrome 프로세스가 생성된 것

![](./img/program.PNG)

![](./img/process.PNG)

- 멀티 태스킹(multi tasking)
  - 두 가지 이상의 작업을 동시에 처리하는 것을 말한다.
- 운영체제는 멀티 태스킹을 할 수 있도록 CPU 및 메모리 자원을 프로세스마다 적절히 할당해주고, 병렬로 실행시킨다.
  - ex) 워드로 문서 작업을 하면서 동시에 윈도우 미디어 플레이어로 음악을 들을 수 있다.
- 멀티 태스킹은 꼭 멀티 프로세스를 뜻하진 않는다.
  - 한 프로세스 내에서 멀티 태스킹을 할 수 있도록 만들어진 애플리케이션들도 있다.
  - 대표적인 것
    - 미디어 플레이어(Media player) : 미디어 플레이어는 동영상 재생과 음악 재생이라는 두 작업을 동시에 처리
    - 메신저(Messenger) : 채팅 기능을 제공하면서 동시에 파일 전송 기능을 수행
- 하나의 프로세스가 어떻게 두 가지 이상의 작업을 처리할까?
  - 멀티 스레드(multi thread)
- 멀티 스레드(multi thread)
  - 스레드(thread)는 사전적 의미로 한 가닥의 실이라는 뜻
  - 한 가지 작업을 실행하기 위해 순차적으로 실행할 코드를 실처럼 이어 놓았다고 해서 유래된 이름
- 하나의 스레드는 하나의 코드 실행 흐름이다.
  - 때문에 한 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다는 의미
- 멀티 프로세스가 애플리케이션 단위의 멀티 태스킹이라면  
  멀티 스레드는 애플리케이션 내부에서의 멀티 태스킹이라고 볼 수 있다.
- 멀티 프로세스와 멀티 스레드의 개념

![](./img/multiProcess.PNG)

- 멀티 프로세스들은 운영체제에서 할당받은 자신의 메모리를 가지고 실행한다.
  - 때문에 서로 독립적이다.
  - 하나의 프로세스에서 오류가 발생해도 다른 프로세스에게 영향을 미치지 않는다.
    - ex) 워드와 엑셀을 동시에 사용하던 도중, 워드에 오류가 생겨 먹통이 되어도 엑셀은 여전히 사용 가능
- 멀티 스레드는 하나의 프로세스 내부에 생성된다.
  - 때문에 하나의 스레드가 예외를 발생시키면 프로세스 자체가 종료될 수 있어 다른 스레드에게 영향을 미치게 된다.
    - ex) 메신저의 경우 파일을 전송하는 스레드에서 예외가 발생되면?  
      메신저 프로세스 자체가 종료되기 때문에 채팅 스레드도 같이 종료됨
- 멀티 스레드에서는 예외 처리에 최선을 다해야 한다.
- 멀티 스레드는 다양한 곳에서 사용된다.
  - ex) 대용량의 데이터 처리 시간을 줄이기 위해 데이터를 분할해서 병렬로 처리하는 곳에서 사용  
    UI를 가지고 있는 애플리케이션에서 네트워크 통신을 하기 위해 사용  
    다수 클라이언트 요청을 처리하는 서버를 개발할 때에도 사용
- 멀티 스레드는 애플리케이션을 개발하는데 꼭 필요한 기능이다.
  - 반드시 이해하고 활용할 수 있도록 해야 한다.

### 메인 스레드

- 모든 자바 애플리케이션은 메인 스레드(main thread)가 main() 메소드를 실행하면서 시작
- 메인 스레드는 main() 메소드의 첫 코드부터 아래로 순차적으로 실행
  - main() 메소드의 마지막 코드를 실행하거나 return문을 만나면 실행이 종료된다.

```java
public static void main(String[] args) {
    String data = null;			// ↓
    if (...) {					// ↓
    }							// ↓
    while(...) {				// ↓
    }							// ↓
    System.out.println("...");  // ↓ 코드의 실행 흐름 → 스레드
}
```

- 메인 스레드는 필요에 따라 작업 스레드들을 만들어 병렬로 코드를 실행할 수 있다.
  - 즉 멀티 스레드를 생성해서 멀티 태스킹을 수행한다.

- 메인 스레드가 작업 스레드1을 생성하고 실행한 다음, 곧이어 작업 스레드2를 생성하고 실행하는 그림

![](./img/thread.PNG)

- 싱글 스레드 애플리케이션에서는 메인 스레드가 종료하면 프로세스도 종료된다.
  - 하지만 멀티 스레드 애플리케이션에서는 실행 중인 스레드가 하나라도 있다면, 프로세스는 종료되지 않는다.
- 메인 스레드가 작업 스레드보다 먼저 종료되더라도 작업 스레드가 계속 실행 중이라면 프로세스는 종료되지 않는다.

## 작업 스레드 생성과 실행

- 멀티 스레드로 실행하는 애플리케이션을 개발하려면?
  - 몇 개의 작업을 병렬로 실행할지 결정하고, 각 작업별로 스레드를 생성해야 한다.

![](./img/threadProgram.PNG)

- 메인 스레드는 반드시 존재하기 때문에 메인작업 이외에 추가적인 병렬 작업의 수만큼 스레드를 생성하면 된다.
- 자바에선 작업 스레드도 객체로 생성되기 때문에 클래스가 필요
- java.lang.Thread 클래스를 직접 객체화해서 생성
  - Thread를 상속해서 하위 클래스를 만들어 생성할 수도 있다.

### Thread 클래스로부터 직접 생성

- java.lang.Thread 클래스로부터 작업 스레드 객체를 직접 생성하려면?
  - Runnable을 매개값으로 갖는 생성자를 호출해야 한다.

```java
Thread thread = new Thread(Runnable target);
```

- Runnable
  - 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체라 해서 붙여진 이름
  - 인터페이스 타입이기 때문에 구현 객체를 만들어 대입해야 한다.
- Runnable에는 run() 메소드 하나가 정의되어 있다.
  - 구현 클래스는 run()을 재정의해서 작업 스레드가 실행할 코드를 작성해야 한다.

```java
// Runnable 구현 클래스를 작성하는 방법
Class Task implements Runnable {
    public void run() {
        스레드가 실행할 코드;
    }
}
```

- Runnable은 작업 내용을 가지고 있는 객체
  - 실제 스레드는 아니다.
- Runnable 구현 객체를 생성하여 매개값으로 Thread 생성자를 호출하면 작업 스레드가 생성된다.

```java
Runnalbe task = new Task();

Thread thread = new Thread(task);
```

- 코드를 절약하기 위해 Thread 생성자를 호출할 때 Runnable 익명 객체를 매개값으로 사용할 수 있다.
  - 이 방법이 더 많이 사용됨

```java
Thread thread new Thread(new Runnable() {
    public void run() {
        스레드가 실행할 코드;
    }
});
```

- Runnable 인터페이스는 run() 메소드 하나만 정의되어 있기 때문에 함수적 인터페이스이다.
  - 람다식을 매개값으로 사용할 수도 있다.
    - 가장 간단하지만, 자바 8부터 지원

```java
Thread thread = new Thread( () -> {
    스레드가 실행할 코드;
} );
```

- 작업 스레드는 생성되는 즉시 실행되는 것이 아니다.
  - start() 메소드를 호출해야만 실행된다.

```java
thread.start();
```

- start() 메소드가 호출되면?
  - 작업 스레드는 매개값으로 받은 Runnable의 run() 메소드를 실행하면서 자신의 작업을 처리
- 0.5초 주기로 비프(beep)음을 발생시키며 동시에 프린팅하는 작업을 가정할 때
  - 비프음 발생과 프린팅은 서로 다른 작업이므로 메인 스레드가 동시에 두 가지 작업을 처리할 수 없음

```java
// 메인 스레드만 이용한 경우 비프음을 모두 발생한 다음, 프린팅을 시작
import java.awt.*;

public class BeepPrintExample1 {

  public static void main(String[] args) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();  // Toolkit 객체 얻기
    for (int i = 0; i < 5; i++) {
      toolkit.beep(); // 비프음 발생
      try {
        Thread.sleep(500); // 0.5초 일시 정지
      } catch (Exception e) { }
    }

    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        Thread.sleep(500); // 0.5초 일시 정지
      } catch (Exception e) { }
    }
  }

}
```

![](./img/BeepPrintExample1.PNG)

- 비프음을 발생시키면서 동시에 프린팅을 하려면?
  - 하나의 작업을 메인 스레드가 아닌 다른 스레드에서 실행시켜야 한다.
- 프린팅은 메인 스레드가, 비프음을 들려주는건 작업 스레드가 담당하도록 수정한 예제

```java
// 작업을 정의하는 Runnable 구현 클래스
import java.awt.*;

public class BeepTask implements Runnable {

  public void run() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();  // Toolkit 객체 얻기
    for (int i = 0; i < 5; i++) {
      toolkit.beep(); // 비프음 발생
      try {
        Thread.sleep(500); // 0.5초 일시 정지
      } catch (Exception e) { }
    }
  }

}
```

```java
// 작업 스레드 생성 및 실행
public class BeepPrintExample2 {

  public static void main(String[] args) {
    Runnable beepTask = new BeepTask(); // BeepTask 객체 생성
    Thread thread = new Thread(beepTask); // 매개값으로 스레드 생성
    thread.start();

    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        Thread.sleep(500);
      } catch (Exception e) { }
    }
  }

}
```

- 또 다른 방법

```java
// Runnable 익명 객체 이용
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();  // Toolkit 객체 얻기
        for (int i = 0; i < 5; i++) {
            toolkit.beep(); // 비프음 발생
            try {
                Thread.sleep(500); // 0.5초 일시 정지
            } catch (Exception e) { }
        }
    }
});
```

```java
// 람다식 이용
Thread thread = new Thread(() -> {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    for (int i = 0; i < 5; i++) {
        toolkit.beep();
        try {
            Thread.sleep(500);
        } catch (Exception e) { }
    }
});
```

### Thread 하위 클래스로부터 생성

- 작업 스레드가 실행할 작업을 Runnable로 만들지 않고, Thread의 하위 클래스로 작업 스레드를 정의하면서 작업 내용을 포함시킬 수도 있다.
  - Thread 클래스를 상속한 후 run 메소드를 재정의해서 스레드가 실행할 코드를 작성

```java
public class WorkerThread extends Thread {
    @Override
    public void run() {
        // 스레드가 실행할 코드;
    }
    Thread thread = new WorkerThread();
}
```

- Thread 익명 객체로 작업 스레드 객체를 생성할 수도 있다.

```java
Thread thread = new Thread() { // 익명 자식 객체
    public void run() {
        // 스레드가 실행할 코드;
    }
}
```

- 작업 스레드 객체에서 start() 메소드 호출시 작업 스레드는 자신의 run() 메소드를 실행한다.

```java
// Runnable을 생성하지 않고 Thread의 하위 클래스로 작업 스레드를 정의한 예제
import java.awt.*;

public class BeepThread extends Thread {
  @Override
  public void run() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    for (int i = 0; i < 5; i++) {
      toolkit.beep();
      try {
        Thread.sleep(500);
      } catch (Exception e) { }
    }
  }
}
```

```java
public class BeepPrintExample3 {

  public static void main(String[] args) {
    Thread thread = new BeepThread(); // BeepThread 객체 생성
    thread.start(); // start() 메소드 호출

    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        thread.sleep(500);
      } catch (Exception e) { }
    }
  }

}
```

- 익명 자식 객체를 사용한 예시

```java
Thread thread = new Thread() { // 익명 자식 객체
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) { }
        }
    }
}
```

### 스레드의 이름

- 스레드는 자신의 이름을 가지고 있다.
  - 스레드의 이름이 큰 역할을 하는 것은 아니지만, 디버깅할 때 어떤 스레드가 어떤 작업을 하는지 조사할 목적으로 가끔 사용됨
- 메인 스레드는 "main" 이라는 이름을 가지고 있다.
  - 직접 생성한 스레드는 자동적으로 "Thread-n" 이라는 이름으로 설정된다.
    - n은 스레드의 번호
- Thread-n 대신 다른 이름으로 설정하고 싶다면 Thread 클래스의 setName() 메소드로 변경하면 된다.

```java
thread.setName("스레드 이름");
```

- 스레드 이름을 알고 싶을 경우에는 getName() 메소드를 호출

```java
thread.getName();
```

- setName()과 getName()은 Thread의 인스턴스 메소드이므로 스레드 객체의 참조가 필요하다.
  - 만약 스레드 객체의 참조를 가지고 있지 않다면?
    - Thread의 정적 메소드인 currentThread()로 코드를 실행하는 현재 스레드의 참조를 얻을 수 있다.

```java
Thread thread = Thread.currentThread();
```

- 예제

```java
// 메인 스레드의 참조를 얻어 스레드 이름을 콘솔에 출력,
// 새로 생성한 스레드의 이름을 setName() 메소드로 설정한 후, getName() 메소드로 읽어오는 예제
public class ThreadNameExample {

  public static void main(String[] args) {
    Thread mainThread = Thread.currentThread(); // 이 코드를 실행하는 스레드 객체 얻기
    System.out.println("프로그램 시작 스레드 이름: " + mainThread.getName());

    ThreadA threadA = new ThreadA(); // ThreadA 생성
    System.out.println("작업 스레드 이름: " + threadA.getName());
    threadA.start(); // ThreadA 시작

    ThreadB threadB = new ThreadB(); // ThreadB 생성
    System.out.println("작업 스레드 이름: " + threadB.getName());
    threadB.start(); // ThreadB 시작
  }

}
```

```java
// ThreadA 클래스
public class ThreadA extends Thread {
  
  public ThreadA() {
    setName("ThreadA"); // 스레드 이름 설정
  }

  @Override
  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.println(getName() + "가 출력한 내용");
    }
  }

}
```

```java
// ThreadB 클래스
public class ThreadB extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.println(getName() + "가 출력한 내용");
    }
  }
  
}
```

![](./img/ThreadNameExample.PNG)

## 스레드 우선순위

- 멀티 스레드는 동시성(Concurrency) 또는 병렬성(Parallelism)으로 실행된다.
- 동시성
  - 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질
- 병렬성
  - 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질
- 싱글 코어 CPU를 이용한 멀티 스레드 작업은 병렬적으로 실행되는 것처럼 보인다.
  - 사실은 번갈아가며 실행하는 동시성 작업
  - 번갈아 실행하는 것이 매우 빨라 병렬성으로 보일 뿐

![](./img/Concur_Paral.PNG)

- 스레드의 개수가 코어의 수보다 많을 경우
  - 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가를 결정해야 한다.
    - 스레드 스케줄링이라고 한다.
- 스레드 스케줄링에 의해 스레드들은 아주 짧은 시간에 번갈아가면서 그들의 run() 메소드를 조금씩 실행한다.

![](./img/threadRun.PNG)

- 자바의 스레드 스케줄링
  - 우선순위 (Priority) 방식
  - 순환 할당 (Round-Robin) 방식을 사용
- 우선 순위 방식
  - 우선순위가 높은 스레드가 실행 상태를 더 많이 가지도록 스케줄링 하는 것
- 순환 할당 방식
  - 시간 할당량 (Time Slice)을 정해서 하나의 스레드를 정해진 시간만큼 실행하고 다시 다른 스레드를 실행하는 방식
- 스레드 우선순위 방식은 스레드 객체에 우선 순위 번호를 부여할 수 있기 때문에 개발자가 코드로 제어할 수 있다.
- 순환 할당 방식은 자바 가상 기계에 의해서 정해지기 때문에 코드로 제어할 수 없다.

---

- 우선 순위 방식에서 우선순위는 1에서부터 10까지 부여된다.
  - 1이 가장 우선순위가 낮고, 10이 가장 높다.
  - 우선순위를 부여하지 않으면 모든 스레드들은 기본적으로 5의 우선순위를 할당받는다.
- 만약 우선순위를 변경하고 싶다면
  - Thread 클래스가 제공하는 setPriority() 메소드를 이용

```java
thread.setPriority(우선순위);
```

- 우선선위의 매개값으로 1~10까지의 값을 주어도 되지만,
  - 코드의 가독성을 높이기 위해 Thread 클래스의 상수를 사용할 수도 있다.

```java
thread.setPriority(Thread.MAX_PRIORITY);	// MAX_PRIORITY는 10
thread.setPriority(Thread.NORM_PRIORITY);	// NORM_PRIORITY는 5
thread.setPriority(Thread.MIN_PRIORITY);	// MIN_PRIORITY는 1의 값을 가진다.
```

- 다른 스레드에 비해 실행 기회를 더 많이 가지려면 MAX_PRIORITY로 우선순위를 높게 설정하면 된다.
- 동일한 계산 작업을 하는 스레드들이 있고, 싱글 코어에서 동시성으로 실행할 경우
  - 우선 순위가 높은 스레드가 실행 기회를 더 많이 가지기 때문에 우선순위가 낮은 스레드보다 계산 작업을 빨리 끝낸다.
- 쿼드 코어일 경우
  - 4개의 스레드가 병렬성으로 실행될 수 있기 때문에 4개 이하의 스레드를 실행할 경우 우선순위 방식이 크게 영향을 미치지 못한다.
  - 최대한 5개 이상의 스레드가 실행되어야 우선순위의 영향을 받음
- 스레드 10개를 생성하고 20억 번의 루핑을 누가 더 빨리 끝내는가를 테스트하는 예제

```java
// 작업 스레드
public class CalcThread extends Thread {

  public CalcThread(String name) {
    setName(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 2000000000; i++) {
    }
    System.out.println(getName());
  }
  
}
```

```java
// 우선순위를 설정해서 스레드 실행
public class PriorityExample {

  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      Thread thread = new CalcThread("thread" + i);
      if (i != 10) { // Thread1~9는 우선순위를 가장 낮게 준다.
        thread.setPriority(Thread.MIN_PRIORITY); // 가장 낮은 우선순위 설정
      } else {
        thread.setPriority(Thread.MAX_PRIORITY); // 가장 높은 우선순위 설정
      }
      thread.start();
    }
  }

}
```

![](./img/PriorityExample.PNG)

## 동기화 메소드와 동기화 블록

### 공유 객체를 사용할 때의 주의할 점

- 싱글 스레드 프로그램
  - 한 개의 스레드가 객체를 독차지해서 사용하면 된다.
- 멀티 스레드 프로그램
  - 스레드들이 객체를 공유해서 작업해야 하는 경우가 있다.
  - 이 경우, 스레드 A를 사용하던 객체가 스레드 B에 의해 상태가 변경될 수 있다.
    - 때문에 스레드 A가 의도했던 것과 다른 결과를 산출할 수도 있다.
    - ex) 계산기를 나눠쓰는 상황에서 A가 계산결과를 저장하였는데, B가 계산기를 만져 저장한 값을 다른 값으로 변경
      - 결국 A가 저장된 값을 이용해서 작업을 진행하면 엉터리 값을 이용하게 된다.
- 예제

```java
// 공유 객체
public class Calculator {
  
  private int memory;

  public int getMemory() {
    return memory;
  }

  public void setMemory(int memory) {
    this.memory = memory;
    try {
      Thread.sleep(2000); // 스레드를 2초간 일시 정지
    } catch (Exception e) { }
    System.out.println(Thread.currentThread().getName() + ": " + this.memory);
  }
  
}
```

```java
// User1 스레드
public class User1 extends Thread {

  private Calculator calculator;

  public void setCalculator(Calculator calculator) {
    this.setName("User1"); // 스레드 이름을 User1 으로 설정
    this.calculator = calculator; // 공유 객체인 Calculator를 필드에 저장
  }

  public void run() {
    calculator.setMemory(100); // 공유 객체인 Calculator의 메모리에 100을 저장
  }

}
```

```java
// User2 스레드
public class User2 extends Thread {

  private Calculator calculator;

  public void setCalculator(Calculator calculator) {
    this.setName("User2"); // 스레드 이름을 User2 으로 설정
    this.calculator = calculator; // 공유 객체인 Calculator를 필드에 저장
  }

  public void run() {
    calculator.setMemory(50); // 공유 객체인 Calculator의 메모리에 50을 저장
  }

}
```

```java
// 메인 스레드가 실행하는 코드
public class MainThreadExample {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    
    User1 user1 = new User1(); // User1 스레드 생성
    user1.setCalculator(calculator); // 공유 객체 설정
    user1.start(); // User1 스레드 시작

    User2 user2 = new User2(); // User2 스레드 생성
    user2.setCalculator(calculator); // 공유 객체 설정
    user2.start(); // User2 스레드 시작
  }

}
```

![](./img/threadExample.PNG)

### 동기화 메소드 및 동기화 블록

- 스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하려면?
  - 스레드 작업이 끝날 때까지 객체에 잠금을 걸어서 다른 스레드가 사용할 수 없도록 해야 한다.
- 임계 영역(critical section)
  - 멀티 스레드 프로그램에서 단 하나의 스레드만 실행할 수 있는 코드 영역
  - 자바는 임계 영역을 지정하기 위해 동기화(synchronized) 메소드와 동기화 블록을 제공
  - 스레드가 객체 내부의 동기화 메소드 또는 블록에 들어가면 즉시 객체에 잠금을 걸어 다른 스레드가 임계 영역 코드를 실행하지 못하도록 한다.
- 동기화 메소드를 만드는 방법
  - 메소드 선언에 synchronized 키워드를 붙이면 된다.
  - synchronized 키워드는 인스턴스와 정적 메소드 어디든 붙일 수 있다.

```java
public synchronized void method() {
    임계 영역; // 단 하나의 스레드만 실행
}
```

- 동기화 메소드
  - 메소드 전체 내용이 임계 영역이므로 스레드가 동기화 메소드를 실행하는 즉시 객체에는 잠금이 일어난다.
  - 스레드가 동기화 메소드를 실행 종료하면 잠금이 풀린다.
- 메소드 전체 내용이 아니라 일부 내용만 임계 영역으로 만들고 싶다면?
  - 동기화 블록(synchronized) 블록을 만들면 된다.

```java
public void method() {
    // 여러 스레드가 실행 가능 영역
    ...
    synchronized(공유객체) { // 공유 객체가 객체 자신이면 this를 넣을 수 있다.
        임계 영역 // 단 하나의 스레드만 실행
    }
    // 여러 스레드가 실행 가능 영역
    ...
}
```

- 동기화 블록의 외부 코드들은 여러 스레드가 동시에 실행할 수 있다.
  - 동기화 블록의 내부 코드는 임계 영역이므로 한 번에 한 스레드만 실행할 수 있고 다른 스레드는 실행할 수 없다.
- 만약 동기화 메소드와 동기화 블록이 여러 개 있을 경우
  - 스레드가 이들 중 하나를 실행할 때 다른 스레드는 해당 메소드는 물론 다른 동기화 메소드 및 블록도 실행할 수 없다.
    - 하지만 일반 메소드는 실행이 가능하다.
- 이전 예제의 공유 객체인 Calculator를 수정한 예제
  - setMemory() 메소드를 동기화 메소드를 만들어 User1 스레드가 setMemory()를 실행하면?
    - User2 스레드가 setMemory() 메소드를 실행할 수 없다.

```java
// 동기화 메소드로 수정된 공유 객체
public class Calculator {

  private int memory;

  public int getMemory() {
    return memory;
  }

  public synchronized void setMemory(int memory) {
    this.memory = memory;
    try {
      Thread.sleep(2000); // 스레드를 2초간 일시 정지
    } catch (Exception e) { }
    System.out.println(Thread.currentThread().getName() + ": " + this.memory);
  }

}
```

- MainThreadExample을 다시 실행하면 User1은 100, User2는 50이라는 출력값을 얻을 수 있다.

![](./img/synchronized.PNG)

- User1 스레드는 Calculator 객체의 동기화 메소드인 setMemory() 를 실행하는 순간 Calculator 객체를 잠근다.
  - 메인 스레드가 User2 스레드를 실행시키지만, 동기화 메소드인 setMemory()를 실행시키지 못한다.
  - User1이 setMemory()를 모두 실행할 동안 대기해야 한다.
- User1 스레드가 setMemory() 메소드를 모두 실행하고 나면 User2 스레드가 setMemory() 메소드를 실행한다.
  - 결국 User1 스레드가 Calculator 객체를 사용할 동안 User2 스레드는 Calculator 객체를 사용하지 못한다.
  - 그러므로 User1 스레드는 안전하게 방해받지 않고 Calculator 객체를 사용할 수 있게 된다.
- 동기화 블록으로도 만들 수 있다.

```java
public void setMemory(int memory) {
    synchronized (this) { // 잠금대상: 공유 객체인 Calculator
        this.memory = memory;
        try {
            Thread.sleep(2000); // 스레드를 2초간 일시 정지
        } catch (Exception e) { }
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }
}
```

- 스레드가 동기화 블록으로 들어가면 this(Calculator 객체)를 잠그고, 동기화 블록을 실행
  - 동기화 블록을 모두 실행할 때까지 다른 스레드들은 this(Calculator 객체)의 모든 동기화 메소드 또는 동기화 블록을 실행할 수 없게 된다.
