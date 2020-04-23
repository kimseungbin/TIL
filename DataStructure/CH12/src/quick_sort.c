#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 10
#define SWAP(x, y, t) ( (t)=(x), (x)=(y), (y)=(t) ) // SWAP 매크로

int list[MAX_SIZE];
int n;

int partition(int list[], int left, int right)
{
    int pivot, temp;
    int low, high;
    
    low = left;
    high = right + 1;
    pivot = list[left];	// 피벗 선택
    do {
        do {
            low++;
        } while (list[low] < pivot);	// 피벗 보다 큰 데이터를 찾으면 멈춘다.
        do {
            high--;
        } while (list[high] > pivot);	// 피벗 보다 작은 데이터를 찾으면 멈춘다.
        if (low < high) SWAP(list[low], list[high], temp);	// 데이터 교환
    } while (low < high);				// low와 high가 교차할 때까지 계속 반복
    
    SWAP(list[left], list[high], temp);	// 피벗 중앙에 위치시키기
    return high;
}

void quick_sort(int list[], int left, int right)
{
    if (left < right) {		// 정렬할 범위가 2개 이상의 데이터라면
        int q = partition(list, left, right);	/* partition 함수 호출하여 피벗 기준 2개로 												  분할. 반환값은 피벗의 위치 */
        quick_sort(list, left, q - 1);	// left에서 피벗 바로 앞까지를 대상으로 순환호출
        quick_sort(list, q + 1, right);	// 피벗 위치 바로 다음부터 right까지 순환호출
    }
}

int main()
{
    int i;
    n = MAX_SIZE;
    srand(time(NULL));
    for (i = 0; i < n; i++) {   // 난수 생성 및 출력
        list[i] = rand() % 100;
    }

    quick_sort(list, 0, n-1);

    for (i = 0; i < n; i++) {
        printf("%d ", list[i]);
    }
    printf("\n");
    return 0;
}