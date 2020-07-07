package io.wisoft.java_seminar.chap11.sec05.exam_getenv;

public class SystemEnvExample {

  public static void main(String[] args) {
    String javaHome = System.getenv("JAVA_HOME");
    System.out.println("JAVA_HOME: " + javaHome);
  }

}
