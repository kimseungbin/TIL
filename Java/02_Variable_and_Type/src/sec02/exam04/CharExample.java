package io.wisoft.java_seminar.chap02.sec02.exam04;

public class CharExample {
	public static void main(String[] args) {
		char c1 = 'A';          //���ڸ� ���� ����
		char c2 = 65;          	//�������� ����
		char c3 = '\u0041';    	//16������ ����
		
		char c4 = '가';         	//���ڸ� ���� ����
		char c5 = 44032;      	//�������� ����
		char c6 = '\uac00';    	//16������ ����
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
	}
}
