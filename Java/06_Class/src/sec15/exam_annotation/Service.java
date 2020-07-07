package io.wisoft.java_seminar.chap06.sec15.exam_annotation;

public class Service {
    @PrintAnnotation		// 엘리먼트의 기본값 적용
    public void method1() {
        System.out.println("실행 내용1");
    }

    @PrintAnnotation("*")	// 기본 엘리먼트인 value값을 "*"로 설정
    public void method2() {
        System.out.println("실행 내용2");
    }

    @PrintAnnotation(value="#", number=20)
    public void method3() {
        System.out.println("실행 내용3");
    }
}