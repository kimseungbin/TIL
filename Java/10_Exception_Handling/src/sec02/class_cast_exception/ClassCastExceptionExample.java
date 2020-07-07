package io.wisoft.java_seminar.chap10.sec02.class_cast_exception;

public class ClassCastExceptionExample {

  public static void main(String[] args) {
    Dog dog = new Dog();
    changeDog(dog);

    Cat cat = new Cat();
    changeDog(cat);
  }

  public static void changeDog(Animal animal) {
    if (animal instanceof Dog) {
      Dog dog = (Dog) animal;
    }
  }

}
