#include<stdio.h>

typedef struct studentTag {
    char name[10]; // ���ڹ迭�� �� �̸�
    int age;        // ���̸� ��Ÿ���� ������
    double gpa;     // ��������� ��Ÿ���� �Ǽ���
} student;

int main()
{
    student a = {"kim", 20, 4.3};
    student b = {"park", 21, 4.2};
    printf("%s\n%d\n%f\n", a.name, a.age, a.gpa);
    return 0;
}