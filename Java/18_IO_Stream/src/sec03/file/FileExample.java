package io.wisoft.java_seminar.ssj_chap14.sec03.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

  public static void main(String[] args) throws Exception {
    
    // File 객체 생성
    File dir = new File("C:/Temp2/images");
    File file1 = new File("C:/Temp2/file1.txt");
    File file2 = new File("C:/Temp2/file2.txt");
    File file3 = new File("C:/Temp2/file3.txt");

    if (dir.exists() == false) {
      dir.mkdirs();
    }
    if (file1.exists() == false) {
      file1.createNewFile();
    }
    if (file2.exists() == false) {
      file2.createNewFile();
    }
    if (file3.exists() == false) {
      file3.createNewFile();
    }

    // C:/Temp2 폴더의 내용 목록을 File 배열로 얻는다.
    File temp = new File("C:/Temp2");
    File[] contents = temp.listFiles();

    System.out.println("시간\t\t\t\t\t\t형태\t\t크기\t이름");
    System.out.println("-------------------------------------------------------");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
    for (File file : contents) {
      System.out.print(sdf.format(new Date(file.lastModified())));
      if (file.isDirectory()) {
        System.out.print("\t<DIR>\t\t\t" + file.getName());
      } else {
        System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
      }
      System.out.println();
    }
  }

}
