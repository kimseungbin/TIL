package io.wisoft.java_seminar.ssj_chap14.sec01.writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample3 {

  public static void main(String[] args) throws Exception {
    Writer writer = new FileWriter("C:/Temp2/test9.txt");

    char[] array = {'A', 'B', 'C', 'D', 'E'};

    // 배열의 1번 인덱스부터 3개를 출력
    writer.write(array, 1, 3);

    writer.flush();
    writer.close();
  }

}
