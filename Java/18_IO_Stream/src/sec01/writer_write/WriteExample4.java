package io.wisoft.java_seminar.ssj_chap14.sec01.writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample4 {

  public static void main(String[] args) throws Exception {
    Writer writer = new FileWriter("C:/Temp2/test10.txt");

    String str = "ABC";

    writer.write(str);

    writer.flush();
    writer.close();
  }

}
