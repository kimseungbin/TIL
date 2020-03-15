#include<stdio.h>

int seq_search(int list[], int key)
{
    int cnt = 0;
    for (int i = 0; i < 10; i++) {
        cnt ++;
        printf("%d\n",cnt);
        if (list[i] == key)
            return i;
    }
    return -1;
}

int main()
{
    int list[] = {5, 9, 10, 17, 21, 29, 33, 37, 38, 43};
    printf("index = %d\n",seq_search(list, 29));
    return 0;
}