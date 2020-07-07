package io.wisoft.java_seminar.chap15.sec06.queue;

public class Message {

  public String command;
  public String to;

  public Message(String command, String to) {
    this.command = command;
    this.to = to;
  }

}
