package io.wisoft.java_seminar.chap11.sec06.exam_new_instance;

public class NewInstanceExample {

  public static void main(String[] args) {
    try {
      Class clazz = Class.forName("io.wisoft.java_seminar.chap11.sec06.exam_new_instance.SendAction");
      //Class clazz = Class.forName("io.wisoft.java_seminar.chap11.sec06.exam_new_instance.ReceiveAction");
      Action action = (Action) clazz.newInstance();
      action.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
  }

}
