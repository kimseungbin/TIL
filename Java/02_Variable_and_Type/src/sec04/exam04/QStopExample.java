package io.wisoft.java_seminar.chap02.sec04.exam04;

public class QStopExample {
	public static void main(String[] args) throws Exception {
		int keyCode;

		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			if(keyCode == 113) {  				       
				break;		//keyCode�� 113�� ������ ��� ����
			}
		}
		
		System.out.println("����");
	}
}

