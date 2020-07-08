package io.wisoft.java_seminar.ssj_chap14.sec02.char_convert_stream;

import java.io.*;

public class CharacterConvertStreamExample {

  public static void main(String[] args) throws Exception {
    write("문자 변환 스트림을 사용합니다.");
    String data = read();
    System.out.println(data);
  }


  public static void write(String str) throws Exception {
    FileOutputStream fos = new FileOutputStream("C:/Temp2/test1.txt");
    // FileOutputStream에 OutputStreamWriter 보조 스트림을 연결
    Writer writer = new OutputStreamWriter(fos);

    writer.write(str); // OutputStreamWriter 보조 스트림을 이용해서 문자 출력
    writer.flush();
    writer.close();
  }


  public static String read() throws Exception {
    FileInputStream fis = new FileInputStream("C:/Temp2/test1.txt");
    // FileInputStream에 InputStreamReader 보조 스트림을 연결
    Reader reader = new InputStreamReader(fis);

    char[] buffer = new char[100];
    int readCharNum = reader.read(buffer); // InputStreamReader 보조 스트림을 이용해서 문자 입력
    reader.close();
    String data = new String(buffer, 0, readCharNum); // char 배열에서 읽은 수만큼 문자열로 변환
    return data;
  }

}
