package io.wisoft.java_seminar.ssj_chap14.sec01.input_stream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {

  public static void main(String[] args) throws Exception {
    InputStream is = new FileInputStream("C:/Temp2/test2.db");

    byte[] buffer = new byte[100];

    while (true) {
      int readByteNum = is.read(buffer); // 배열 길이만큼 읽기
      if (readByteNum == -1) break;
      for (int i = 0; i < readByteNum; i++) {
        System.out.println(buffer[i]);
      }
    }

    is.close();
  }

}
