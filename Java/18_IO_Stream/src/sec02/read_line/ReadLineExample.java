package io.wisoft.java_seminar.ssj_chap14.sec02.read_line;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class ReadLineExample {

  public static void main(String[] args) throws Exception {
    Reader reader = new FileReader(
        ReadLineExample.class.getResource("language.txt").getPath()
    );
    BufferedReader br = new BufferedReader(reader); // 보조 스트림 연결

    while (true) {
      String data = br.readLine();
      if (data == null) break;
      System.out.println(data);
    }

    br.close();
  }

}
