package io.wisoft.java_seminar.chap11.sec06.exam_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

  public static void main(String[] args) throws Exception {
    Class clazz = Class.forName("io.wisoft.java_seminar.chap11.sec06.exam_reflection.Car");

    System.out.println("[클래스 이름]");
    System.out.println(clazz.getName());
    System.out.println();

    // 생성자 이름과 매개 변수 정보를 출력
    System.out.println("[생성자 정보]");
    Constructor[] constructors = clazz.getDeclaredConstructors();
    for (Constructor constructor : constructors) {
      System.out.print(constructor.getName() + "(");
      Class[] parameters = constructor.getParameterTypes();
      printParameters(parameters);
      System.out.println(")");
    }
    System.out.println();

    // 필드 타입과 필드 이름을 출력
    System.out.println("[필드 정보]");
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      System.out.println(field.getType().getSimpleName() + " " + field.getName());
    }
    System.out.println();

    // 메소드 이름과 매개 변수를 출력
    System.out.println("[메소드 정보]");
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      System.out.print(method.getName() + "(");
      Class[] parameters = method.getParameterTypes();
      printParameters(parameters);
      System.out.println(")");
    }

  }

  private static void printParameters(Class[] parameters) {
    for (int i = 0; i < parameters.length; i++) {
      System.out.print(parameters[i].getName());
      if (i < (parameters.length - 1)) {
        System.out.print(",");
      }
    }
  }

}

class Car {
  private String model;
  private String owner;

  public String getOwner() {
    return owner;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getModel() {
    return model;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

}

