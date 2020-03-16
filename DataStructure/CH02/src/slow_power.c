#include<stdio.h>

double slow_power(double x, int n)
{
    double result = 1.0;

    for(int i=0; i<n; i++)
        result *= x;
    return(result);
}

int main()
{
    printf("%f",slow_power(2, 10));
    return 0;
}