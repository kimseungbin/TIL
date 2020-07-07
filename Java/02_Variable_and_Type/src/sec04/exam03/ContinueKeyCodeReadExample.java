package io.wisoft.java_seminar.chap02.sec04.exam03;

public class ContinueKeyCodeReadExample {
	public static void main(String[] args) throws Exception {
		int keyCode;

		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
		}
	}
}

