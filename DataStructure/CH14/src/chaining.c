#include <stdio.h>
#include <stdlib.h>

#define TABLE_SIZE 7	// �ؽ� ���̺��� ũ�� = �Ҽ�

typedef struct {
    int key;
} element;

struct list {
    element item;
    struct list *link;
};

struct list *hash_table[TABLE_SIZE];

// ���� �Լ��� �̿��� �ؽ� �Լ�
int hash_function(int key)
{
    return key % TABLE_SIZE;
}

// ü�ι��� �̿��Ͽ� ���̺� Ű�� ����
void hash_chain_add(element item, struct list *ht[])
{
    int hash_value = hash_function(item.key);
    struct list *ptr;
    struct list *node_before = NULL, *node = ht[hash_value];
    for ( ; node != NULL; node_before = node, node = node->link) {	// ����Ű �˻�
        // node���� NULL��, node_before���� NULL �ٷ� ���� �����Ͱ� �����(���������)
        if (node->item.key == item.key) {
            fprintf(stderr, "�̹� Ž��Ű�� ����Ǿ� ����\n");
            return;
        }
    }
    ptr = (struct list *)malloc(sizeof(struct list));	// ��� ����
    ptr->item = item;	// Ű ����
    ptr->link = NULL;	// ������ ����̹Ƿ� ��ũ�ʵ�� NULL
    if (node_before) {	// ���� ���Ḯ��Ʈ�� �ִٸ�
        node_before->link = ptr; // �� ���� ��� ����
    }
    else ht[hash_value] = ptr;	// ���� ���Ḯ��Ʈ�� ���ٸ� �ؽ����̺� �����Ϳ� ����
}

// ü�ι��� �̿��Ͽ� ���̺� ����� Ű�� Ž��
void hash_chain_search(element item, struct list *ht[])
{
    struct list *node;
    
    int hash_value = hash_function(item.key);
    for (node = ht[hash_value]; node != NULL; node = node->link) {	// ����Ű �˻�
        if (node->item.key == item.key) {
            fprintf(stderr, "Ž�� %d ����\n", item.key);
            return;
        }
    }
    printf("Ű�� ã�� ������\n");
}

// �ؽ� ���̺��� ������ ���
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
// �ؽ� ���̺��� ����� ����
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