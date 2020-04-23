#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 10
#define SWAP(x, y, t) ( (t)=(x), (x)=(y), (y)=(t) ) // SWAP ��ũ��

int list[MAX_SIZE];
int n;

int partition(int list[], int left, int right)
{
    int pivot, temp;
    int low, high;
    
    low = left;
    high = right + 1;
    pivot = list[left];	// �ǹ� ����
    do {
        do {
            low++;
        } while (list[low] < pivot);	// �ǹ� ���� ū �����͸� ã���� �����.
        do {
            high--;
        } while (list[high] > pivot);	// �ǹ� ���� ���� �����͸� ã���� �����.
        if (low < high) SWAP(list[low], list[high], temp);	// ������ ��ȯ
    } while (low < high);				// low�� high�� ������ ������ ��� �ݺ�
    
    SWAP(list[left], list[high], temp);	// �ǹ� �߾ӿ� ��ġ��Ű��
    return high;
}

void quick_sort(int list[], int left, int right)
{
    if (left < right) {		// ������ ������ 2�� �̻��� �����Ͷ��
        int q = partition(list, left, right);	/* partition �Լ� ȣ���Ͽ� �ǹ� ���� 2���� 												  ����. ��ȯ���� �ǹ��� ��ġ */
        quick_sort(list, left, q - 1);	// left���� �ǹ� �ٷ� �ձ����� ������� ��ȯȣ��
        quick_sort(list, q + 1, right);	// �ǹ� ��ġ �ٷ� �������� right���� ��ȯȣ��
    }
}

int main()
{
    int i;
    n = MAX_SIZE;
    srand(time(NULL));
    for (i = 0; i < n; i++) {   // ���� ���� �� ���
        list[i] = rand() % 100;
    }

    quick_sort(list, 0, n-1);

    for (i = 0; i < n; i++) {
        printf("%d ", list[i]);
    }
    printf("\n");
    return 0;
}