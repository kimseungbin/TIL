package io.wisoft.java_seminar.chap13.sec06;

import java.util.Arrays;

public class WildCardExample {

  public static void registerCourse(Course<?> course) { // 모든 과정
    System.out.println(course.getName() + " 수강생: " +
        Arrays.toString(course.getStudents()));
  }

  public static void registerCourseStudent(Course<? extends Student> course) { // 학생 과정
    System.out.println(course.getName() + " 수강생: " +
        Arrays.toString(course.getStudents()));
  }

  public static void registerCourseWorker(Course<? super Worker> course) { // 직장인과 일반인 과정
    System.out.println(course.getName() + " 수강생: " +
        Arrays.toString(course.getStudents()));
  }

  public static void main(String[] args) {
    Course<Person> personCourse = new Course<>("일반인과정", 5);
    personCourse.add(new Person("일반인"));
    personCourse.add(new Worker("직장인"));
    personCourse.add(new Student("학생"));
    personCourse.add(new HighStudent("고등학생"));

    Course<Worker> workerCourse = new Course<>("직장인과정", 5);
    workerCourse.add(new Worker("직장인"));

    Course<Student> studentCourse = new Course<>("학생과정", 5);
    studentCourse.add(new Student("학생"));
    studentCourse.add(new HighStudent("고등학생"));

    Course<Student> highStudentCourse = new Course<>("고등학생과정", 5);
    highStudentCourse.add(new HighStudent("고등학생"));

    registerCourse(personCourse);
    registerCourse(workerCourse);
    registerCourse(studentCourse);
    registerCourse(highStudentCourse);
    System.out.println();

    // registerCourseStudent(personCourse); (X)
    // registerCourseStudent(workerCourse); (X)
    // 학생 과정만 등록 가능
    registerCourseStudent(studentCourse);
    registerCourseStudent(highStudentCourse);
    System.out.println();

    // 직장인과 일반인 과정만 등록 가능
    registerCourseWorker(personCourse);
    registerCourseWorker(workerCourse);
    // registerCourseStudent(studentCourse); (X)
    // registerCourseStudent(highStudentCourse); (X)
  }

}