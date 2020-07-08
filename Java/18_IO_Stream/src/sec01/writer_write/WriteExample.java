package io.wisoft.java_seminar.ssj_chap14.sec01.writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample {

  public static void main(String[] args) throws Exception {
    // 데이터 도착지를 test7.txt로 하는 문자 기반 파일 출력 스트림을 생성
    Writer writer = new FileWriter("C:/Temp2/test7.txt");

    char a = 'A';
    char b = 'B';
    char c = 'C';

    // 한 문자씩 출력
    writer.write(a);
    writer.write(b);
    writer.write(c);

    writer.flush();
    writer.close();
  }

}
