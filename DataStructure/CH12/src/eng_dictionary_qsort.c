#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_WORD_SIZE 50
#define MAX_MEANING_SIZE 500
#define SIZE 5

typedef struct {
    char word[MAX_WORD_SIZE];
    char meaning[MAX_MEANING_SIZE];
} element;

element list[SIZE];

int compare(const void *a, const void *b) {
    return strcmp( (char*)a, (char*)b);
}

int main()
{
    int i;

    printf("5���� �ܾ�� �ǹ̸� �Է��ϼ���.\n");

    for (i = 0; i < SIZE; i++) {
        scanf("%s[^\n]", list[i].word);     // ���͸� �����ϰ� ����
        scanf("%s[^\n]", list[i].meaning);  // ���͸� �����ϰ� ����
    }

    qsort((void*)list, SIZE, sizeof(element), compare);

    printf("\n���� �� ���� :\n");
    for (i = 0; i < SIZE; i++) {
        printf("%s : %s \n", list[i].word, list[i].meaning);
    }

    return 0;
}