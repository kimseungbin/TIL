package io.wisoft.java_seminar.chap13.sec07;

public class ChildProductAndStorageExample {

  public static void main(String[] args) {
    ChildProduct<Tv, String, String> product = new ChildProduct<>();
    product.setKind(new Tv());
    product.setModel("SmartTV");
    product.setCompany("Samsung");

    Storage<Tv> storage = new StorageImple<>(100);
    storage.add(new Tv(), 0);
    Tv tv = storage.get(0);
  }

}

class Tv {

}
