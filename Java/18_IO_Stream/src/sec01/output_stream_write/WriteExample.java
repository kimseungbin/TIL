package io.wisoft.java_seminar.ssj_chap14.sec01.output_stream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {

  public static void main(String[] args) throws Exception {
    // 데이터 도착지를 test1.db로 하는 바이트 기반 파일 출력 스트림을 생성
    OutputStream os = new FileOutputStream("C:/Temp2/test1.db");

    byte a = 10;
    byte b = 20;
    byte c = 30;

    // 1byte씩 출력
    os.write(a);
    os.write(b);
    os.write(c);

    os.flush(); // 출력 버퍼에 잔류하는 모든 바이트 출력
    os.close(); // 출력 스트림 닫기
  }

}
