package io.wisoft.java_seminar.ssj_chap14.sec01.writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample2 {

  public static void main(String[] args) throws Exception {
    Writer writer = new FileWriter("C:/Temp2/test8.txt");

    char[] array = {'A', 'B', 'C'};

    writer.write(array);

    writer.flush();
    writer.close();
  }

}
