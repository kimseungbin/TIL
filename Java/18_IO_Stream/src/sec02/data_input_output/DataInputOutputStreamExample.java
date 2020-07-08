package io.wisoft.java_seminar.ssj_chap14.sec02.data_input_output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {

  public static void main(String[] args) throws Exception {
    
    // 바이트 기반 출력 스트림을 생성하고 DataOutputStream 보조 스트림 연결
    FileOutputStream fos = new FileOutputStream("C:/Temp2/primitive.db");
    DataOutputStream dos = new DataOutputStream(fos);
    
    // 기본 타입 값 출력
    dos.writeUTF("홍길동");
    dos.writeDouble(95.5);
    dos.writeInt(1);

    dos.writeUTF("김자바");
    dos.writeDouble(90.3);
    dos.writeInt(2);

    dos.flush();
    dos.close();

    // 바이트 기반 입력 스트림을 생성하고 DataInputStream 보조 스트림 연결
    FileInputStream fis = new FileInputStream("C:/Temp2/primitive.db");
    DataInputStream dis = new DataInputStream(fis);

    for (int i = 0; i < 2; i++) {
      String name = dis.readUTF();
      double score = dis.readDouble();
      int order = dis.readInt();
      System.out.println(name + " : " + score + " : " + order);
    }

    dis.close();
  }

}
