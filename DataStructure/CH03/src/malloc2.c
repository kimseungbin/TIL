#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct studentTag {
    char name[10];  // ���ڹ迭�� �� �̸�
    int age;        // ���̸� ��Ÿ���� ������
    double gpa;     // ��������� ��Ÿ���� �Ǽ���
} student;

int main()
{
    student *s;

    s = (student *)malloc(sizeof(student));
    if (s == 0) {
        fprintf(stderr, "�޸𸮰� �����ؼ� �Ҵ��� �� �����ϴ�.");
        exit(1);
    }

    strcpy(s->name, "Park");
    s->age = 20;

    free(s);
    return 0;
}