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

    printf("5개의 단어와 의미를 입력하세요.\n");

    for (i = 0; i < SIZE; i++) {
        scanf("%s[^\n]", list[i].word);     // 엔터만 제외하고 받음
        scanf("%s[^\n]", list[i].meaning);  // 엔터만 제외하고 받음
    }

    qsort((void*)list, SIZE, sizeof(element), compare);

    printf("\n정렬 후 내용 :\n");
    for (i = 0; i < SIZE; i++) {
        printf("%s : %s \n", list[i].word, list[i].meaning);
    }

    return 0;
}