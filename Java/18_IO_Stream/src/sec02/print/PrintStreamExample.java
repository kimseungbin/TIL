package io.wisoft.java_seminar.ssj_chap14.sec02.print;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {

  public static void main(String[] args) throws Exception {

    // 바이트 기반 출력 스트림을 생성하고 PrintStream 보조 스트림 연결
    FileOutputStream fos = new FileOutputStream("C:/Temp2/printstream.txt");
    PrintStream ps = new PrintStream(fos);

    ps.println("[프린터 보조 스트림]");
    ps.print("마치 ");
    ps.println("프린터가 출력하는 것처럼 ");
    ps.println("데이터를 출력합니다.");

    ps.flush();
    ps.close();

  }

}
