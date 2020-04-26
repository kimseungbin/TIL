#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define KEY_SIZE 10		// Ž��Ű�� �ִ����
#define TABLE_SIZE 13	// �ؽ� ���̺��� ũ�� = �Ҽ�

typedef struct {
    char key[KEY_SIZE];
    // ... �ٸ� �ʿ��� �ʵ��
} element;

element hash_table[TABLE_SIZE];		// �ؽ� ���̺�

void init_table(element ht[]) // �ؽ� ���̺� �ʱ�ȭ
{
    int i;
    for (i = 0; i < TABLE_SIZE; i++) {
        ht[i].key[0] = '\0';
    }
}

// ���ڷ� �� Ű�� ���ڷ� ��ȯ
int transform(char *key)
{
    int number = 0;
    
    while (*key) {
        number += *key++;
    }
    return number;
}
// ���� �Լ��� ����� �ؽ� �Լ�
int hash_function(char *key)
{
    // Ű�� �ڿ����� ��ȯ�� ���� ���̺��� ũ��� ������ �������� ��ȯ
    return transform(key) % TABLE_SIZE;
}

#define empty(item) (strlen(item.key)==0)
#define equal(item1, item2) (!strcmp(item1.key, item2.key))

// ���� ������� �̿��� ���̺� Ű�� �����ϰ�, ���̺��� ���� �� ���� ����
void hash_lp_add(element item, element ht[])
{
    int i, hash_value;
    hash_value = i = hash_function(item.key);
    
    while(!empty(ht[i])) {	// ��Ŷ�� ������� �ʴٸ�
        if (equal(item, ht[i])) {	// Ž��Ű�� �ߺ��� ���
            fprintf(stderr, "Ž��Ű�� �ߺ��Ǿ����ϴ�.\n");
            exit(1);
        }
        
        i = (i + 1) % TABLE_SIZE;	// ���� ��Ŷ����
        if (i == hash_value) {	// ��� ����������, �� ��Ŷ�� ���� ���
            fprintf(stderr, "���̺��� ����á���ϴ�.\n");
            exit(1);
        }
    }
    ht[i] = item;
}

// ���� ������� �̿��Ͽ� ���̺� ����� Ű�� Ž��
void hash_lp_search(element item, element ht[])
{
    int i, hash_value;
    hash_value = i = hash_function(item.key);
    
    while(!empty(ht[i])) {	// ��Ŷ�� ������� �ʴٸ�
        if (equal(item, ht[i])) {	// Ž��Ű�� ã�����
            fprintf(stderr, "Ž�� %s : ��ġ = %d\n", item.key, i);
            return;
        }
        
        i = (i + 1) % TABLE_SIZE;	// ��ã������ ���� ��Ŷ����
        if (i == hash_value) {	// ��� ����������, ã�� ���Ѱ��
            fprintf(stderr, "ã�� ���� ���̺� ����\n");
            return;
        }
    }
    fprintf(stderr, "ã�� ���� ���̺� ����\n");
}

// �ؽ� ���̺��� ������ ���
void hash_lp_print(element ht[])
{
    int i;
    printf("\n==============================\n");
    for (i = 0; i < TABLE_SIZE; i++) {
        printf("[%d] %s\n", i, ht[i].key);
    }
    printf("\n==============================\n\n");
}

// �ؽ� ���̺��� ����� ����
int main()
{
    char *s[7] = {"do", "for", "if", "case", "else", "return", "function"};
    element e;

    for (int i = 0; i < 7; i++) {
        strcpy(e.key, s[i]);
        hash_lp_add(e, hash_table);
        hash_lp_print(hash_table);
    }
    for (int i = 0; i < 7; i++) {
        strcpy(e.key, s[i]);
        hash_lp_search(e, hash_table);
    }
    return 0;
}