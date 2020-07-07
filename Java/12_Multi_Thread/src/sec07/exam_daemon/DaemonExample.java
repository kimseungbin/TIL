package io.wisoft.java_seminar.chap12.sec07.exam_daemon;

public class DaemonExample {

  public static void main(String[] args) {
    AutoSaveThread autoSaveThread = new AutoSaveThread();
    autoSaveThread.setDaemon(true); // AutoSaveThread를 데몬 스레드로 만든다.
    autoSaveThread.start();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) { }

    System.out.println("메인 스레드 종료");
  }

}
