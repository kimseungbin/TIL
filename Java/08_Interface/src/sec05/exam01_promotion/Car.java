package io.wisoft.java_seminar.chap08.sec05.exam01_promotion;

public class Car {
  Tire[] tires = {
      new HankookTire(),
      new HankookTire(),
      new HankookTire(),
      new HankookTire()
  };

  void run() {
    for (Tire tire : tires) {
      tire.roll();
    }
  }
}
