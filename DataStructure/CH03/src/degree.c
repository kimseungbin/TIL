#include<stdio.h>

#define MAX_DEGREE 101 // 다항식의 최대차수 + 1

typedef struct {
    int degree;
    float coef[MAX_DEGREE];
} polynomial;

int main()
{
    polynomial a = {5, {10, 0, 0, 0, 6, 3}};
    printf("%d\n", a.degree);
    for ( int i = 0; i <= MAX_DEGREE; i++) printf("%f\n", a.coef[i]);
}