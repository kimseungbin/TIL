package io.wisoft.java_seminar.chap09.sec05.exam03_button;

public class Button {

  OnClickListener listener;

  void setOnClickListener(OnClickListener listener) {
    this.listener = listener;
  }

  void touch() {
    listener.onClick();
  }

  interface OnClickListener {
    void onClick();
  }

}
