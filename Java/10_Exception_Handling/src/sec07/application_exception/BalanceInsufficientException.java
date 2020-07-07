package io.wisoft.java_seminar.chap10.sec07.application_exception;

public class BalanceInsufficientException extends Exception {

  public BalanceInsufficientException() {
  }

  public BalanceInsufficientException(String message) {
    super(message);
  }

}