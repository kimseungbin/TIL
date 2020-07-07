package io.wisoft.java_seminar.chap12.sec06.exam_data_box;

public class WaitNotifyExample {

  public static void main(String[] args) {
    DataBox dataBox = new DataBox();

    ProducerThread producerThread = new ProducerThread(dataBox);
    ConsumerThread consumerThread = new ConsumerThread(dataBox);

    producerThread.start();
    consumerThread.start();
  }

}
