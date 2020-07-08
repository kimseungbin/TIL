package io.wisoft.java_seminar.ssj_chap14.sec01.input_stream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample3 {

  public static void main(String[] args) throws Exception {
    InputStream is = new FileInputStream("C:/Temp2/test3.db");

    byte[] buffer = new byte[5];

    int readByteNum = is.read(buffer, 2, 3);
    if (readByteNum != -1) { // 읽은 바이트가 있다면
      for (int i = 0; i < buffer.length; i++) {
        System.out.println(buffer[i]);
      }
    }

    is.close();
  }

}
