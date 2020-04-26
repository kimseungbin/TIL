#include <stdio.h>
#include <stdlib.h>

#define TABLE_SIZE 7	// 해싱 테이블의 크기 = 소수

typedef struct {
    int key;
} element;

struct list {
    element item;
    struct list *link;
};

struct list *hash_table[TABLE_SIZE];

// 제산 함수를 이용한 해싱 함수
int hash_function(int key)
{
    return key % TABLE_SIZE;
}

// 체인법을 이용하여 테이블에 키를 삽입
void hash_chain_add(element item, struct list *ht[])
{
    int hash_value = hash_function(item.key);
    struct list *ptr;
    struct list *node_before = NULL, *node = ht[hash_value];
    for ( ; node != NULL; node_before = node, node = node->link) {	// 동일키 검사
        // node에는 NULL이, node_before에는 NULL 바로 앞의 포인터가 저장됨(마지막노드)
        if (node->item.key == item.key) {
            fprintf(stderr, "이미 탐색키가 저장되어 있음\n");
            return;
        }
    }
    ptr = (struct list *)malloc(sizeof(struct list));	// 노드 생성
    ptr->item = item;	// 키 복사
    ptr->link = NULL;	// 마지막 노드이므로 링크필드는 NULL
    if (node_before) {	// 기존 연결리스트가 있다면
        node_before->link = ptr; // 맨 끝에 노드 연결
    }
    else ht[hash_value] = ptr;	// 기존 연결리스트가 없다면 해시테이블 포인터에 연결
}

// 체인법을 이용하여 테이블에 저장된 키를 탐색
void hash_chain_search(element item, struct list *ht[])
{
    struct list *node;
    
    int hash_value = hash_function(item.key);
    for (node = ht[hash_value]; node != NULL; node = node->link) {	// 동일키 검사
        if (node->item.key == item.key) {
            fprintf(stderr, "탐색 %d 성공\n", item.key);
            return;
        }
    }
    printf("키를 찾지 못했음\n");
}

// 해싱 테이블의 내용을 출력
void hash_chain_print(struct list *ht[])
{
    struct list *node;
    int i;
    printf("\n==============================\n");
    for (i = 0; i < TABLE_SIZE; i++) {
        printf("[%d]->", i);
        for (node = ht[i]; node != NULL; node = node->link) {
            printf("%d->", node->item.key);
        }
        printf("\n");
    }
    printf("\n==============================\n\n");
}

#define SIZE 5
// 해싱 테이블을 사용한 예제
int main()
{
    int data[SIZE] = {8, 1, 9, 6, 13};
    element e;

    for (int i = 0; i < SIZE; i++) {
        e.key = data[i];
        hash_chain_add(e, hash_table);
        hash_chain_print(hash_table);
    }
    for (int i = 0; i < SIZE; i++) {
        e.key = data[i];
        hash_chain_search(e, hash_table);
    }
    return 0;
}