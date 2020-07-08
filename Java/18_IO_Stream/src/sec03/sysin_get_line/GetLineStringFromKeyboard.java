package io.wisoft.java_seminar.ssj_chap14.sec03.sysin_get_line;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GetLineStringFromKeyboard {

  public static void main(String[] args) throws Exception {
    InputStream is = System.in;
    Reader reader = new InputStreamReader(is); // InputStream을 Reader로 변환
    BufferedReader br = new BufferedReader(reader); // 다시 보조스트림 연결

    while (true) {
      System.out.print("입력하세요: ");
      String lineStr = br.readLine(); // 라인 단위로 문자열을 읽음
      if (lineStr.equals("q") || lineStr.equals("quit")) break;
      System.out.print("입력된내용: " + lineStr);
      System.out.println();
    }

    br.close();
  }

}
