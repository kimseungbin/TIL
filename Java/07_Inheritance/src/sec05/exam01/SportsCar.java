package io.wisoft.java_seminar.chap07.sec05.exam01;

public class SportsCar extends Car {
    @Override
    public void speedUp() {
        speed += 10;
    }

    // 오버라이딩을 할 수 없음
//    @Override
//    public void stop() {
//        System.out.println("스포츠카를 멈춤");
//        speed = 0;
//    }
}
