#include<stdio.h>

int factorial_iter(int n)
{
    int i, result = 1;
    for(i=1; i<=n; i++)
        result *= i;
    return(result);
}

int main()
{
    int n;
    printf("! : ");
    scanf("%d", &n);
    printf("%d",factorial_iter(n));
    return 0;
}