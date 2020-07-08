package io.wisoft.java_seminar.ssj_chap14.sec03.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductStorage {

  private List<Product> list = new ArrayList<>(); // List 컬렉션 생성
  private Scanner scanner = new Scanner(System.in);
  private int counter;
  
  public void showMenu() {
    while (true) {
      System.out.println("-----------------------------");
      System.out.println("1. 등록 | 2. 목록 | 3. 종료");
      System.out.println("-----------------------------");

      System.out.print("선택: ");
      String selectNo = scanner.nextLine(); // 번호 읽기
      switch (selectNo) {
        case "1":
          registerProduct();
          break;
        case "2":
          showProducts();
          break;
        case "3":
          return;
      }
    }
  }

  public void registerProduct() {
    try {
      Product product = new Product();
      product.setPno(++counter); // pno 세팅

      System.out.print("상품명: ");
      product.setName(scanner.nextLine()); // 이름 읽고 세팅

      System.out.print("가격: ");
      product.setPrice(Integer.parseInt(scanner.nextLine())); // 가격 읽고 세팅

      System.out.print("재고: ");
      product.setStock(Integer.parseInt(scanner.nextLine())); // 재고를 읽고 세팅

      list.add(product); // list에 Product 저장
    } catch (Exception e) {
      System.out.println("등록 에러: " + e.getMessage());
    }
  }

  public void showProducts() {
    for (Product p : list) {
      System.out.println(p.getPno() + "\t" + p.getName() + "\t" +
          p.getPrice() + "\t" + p.getStock());
    }
  }

}
