package io.wisoft.java_seminar.ssj_chap14.sec01.reader_read;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample {

  public static void main(String[] args) throws Exception {
    Reader reader = new FileReader("C:/Temp2/test7.txt");

    while (true) {
      int data = reader.read(); // 한 문자씩 읽기
      if (data == -1) break; // 파일 끝에 도달했을 경우
      System.out.println((char) data);
    }

    reader.close();
  }

}
