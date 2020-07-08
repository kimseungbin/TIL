package io.wisoft.java_seminar.ssj_chap14.sec01.reader_read;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample2 {

  public static void main(String[] args) throws Exception {
    Reader reader = new FileReader("C:/Temp2/test8.txt");

    char[] buffer = new char[100];

    while (true) {
      int readCharNum = reader.read(buffer); // 배열 길이만큼 읽기
      if (readCharNum == -1) break;
      for (int i = 0; i < readCharNum; i++) {
        System.out.println(buffer[i]);
      }
    }

    reader.close();
  }

}
