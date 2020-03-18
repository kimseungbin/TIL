#include<stdio.h>
#define MAX(a,b) (((a)>(b)?(a):(b)))
#define MAX_DEGREE 101

typedef struct {            // 다항식 구조체 타입 선언
    int degree;             // 다항식의 차수
    float coef[MAX_DEGREE]; // 다항식의 계수
} polynomial;

polynomial poly_add1(polynomial A, polynomial B)
{
    polynomial C;                       // 결과 다항식
    int Apos = 0, Bpos = 0, Cpos = 0;   // 배열 인덱스 변수
    int degree_a = A.degree;
    int degree_b = B.degree;
    C.degree = MAX(A.degree, B.degree);

    while (Apos <= A.degree && Bpos <= B.degree) {
        if (degree_a > degree_b) {      // A항 > B항
            C.coef[Cpos++] = A.coef[Apos++];
            degree_a--;
        }
        else if (degree_a == degree_b) {// A항 == B항
            if (A.coef[Apos] + B.coef[Bpos] == 0 && C.degree == degree_a) {
                C.degree--;
                degree_a--; degree_b--;
                Apos++; Bpos++;
            }
            else {
                C.coef[Cpos++] = A.coef[Apos++] + B.coef[Bpos++];
                degree_a--; degree_b--;
            }
        }
        else {                          // B항 > A항
            C.coef[Cpos++] = B.coef[Bpos++];
            degree_b--;
        }
    }
    return C;
}

void print_poly(polynomial p)
{
    for (int i = p.degree; i > 0; i--) printf("%3.1fx^%d + ", p.coef[p.degree - i], i);
    printf("%3.1f\n", p.coef[p.degree]);
}

//주함수
int main()
{
    polynomial a = {3, {1, 0, 2, 3}};
    polynomial b = {3, {-1, 0, 4, -1}};
    // polynomial a = {5, {3, 6, 0, 0, 0, 10}};
    // polynomial b = {4, {7, 0, 5, 0, 1}};
    polynomial c;

    print_poly(a);
    print_poly(b);
    c = poly_add1(a, b);
    printf("--------------------------------------\n");
    print_poly(c);
    printf("결과의 최고차수 : %d\n", c.degree);
    return 0;
}