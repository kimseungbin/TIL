package io.wisoft.java_seminar.chap10.sec05.auto_closeable;

public class TryWithResourceExample {

  public static void main(String[] args) {
    try (FileInputStream fis = new FileInputStream("file.txt")) {
      fis.read();
      throw new Exception(); // 예외 강제발생
    } catch (Exception e) {
      System.out.println("예외 처리 코드가 실행되었습니다.");
    }
  }

}
