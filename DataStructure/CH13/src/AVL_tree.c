#include <stdio.h>
#include <stdlib.h>
#define MAX(a, b) ( (a) > (b) ? (a) : (b) )

// AVL Ʈ�� ��� ����
typedef struct _AVLNode {
    int key;
    struct _AVLNode *left;
    struct _AVLNode *right;
} AVLNode;

// Ʈ���� ���̸� ��ȯ
int get_height(AVLNode *node)
{
    int height = 0;
    
    if (node != NULL) {
        height = 1 + MAX(get_height(node->left), get_height(node->right));
    }
    
    return height;
}
// ����� �����μ��� ��ȯ
int get_balance(AVLNode *node)
{
    if (node == NULL) return 0;
    
    return get_height(node->left) - get_height(node->right);
}

// ��带 �������� �����ϴ� �Լ�
AVLNode* create_node(int key)
{
    AVLNode* node = (AVLNode*)malloc(sizeof(AVLNode));
    node->key = key;
    node->left = NULL;
    node->right = NULL;
    return node;
}

// ���������� ȸ����Ű�� �Լ�
AVLNode* rotate_right(AVLNode *parent)
{
    AVLNode* child = parent->left;
    parent->left = child->right; // �θ����� ���ʿ� �ڽĳ���� ������ ��带 �����ϰ�
    child->right = parent;		// �ڽĳ���� �����ʿ� �θ��带 �����Ų��.
    // ���ο� ��Ʈ�� ��ȯ
    return child;
}

// �������� ȸ����Ű�� �Լ�
AVLNode* rotate_left(AVLNode *parent)
{
    AVLNode* child = parent->right;
    parent->right = child->left; // �θ����� �����ʿ� �ڽĳ���� ���� ��带 �����ϰ�
    child->left = parent;		// �ڽĳ���� ���ʿ� �θ��带 �����Ų��.
    // ���ο� ��Ʈ�� ��ȯ
    return child;
}

// AVL Ʈ���� ���ο� ��� �߰� �Լ�
AVLNode* insert(AVLNode *node, int key)
{
    // ���� Ž�� Ʈ���� ��� �߰� ����
    if (node == NULL) {	// Ž���� ������ ��ġ�� ���� ��ġ�� �ȴ�.
        return (create_node(key));
    }
    
    if (key < node->key) {
        node->left = insert(node->left, key);
    }
    else if (key > node->key) {
        node->right = insert(node->right, key);
    }
    else return node;	// ������ Ű�� ������ ����
    
    // ������ �����μ� ���
    int balance = get_balance(node);
    
    // �� ��尡 ���� �ڽ��� ���ʿ� �߰��Ǿ��ٸ� LLŸ��
    if (balance > 1 && key < node->left->key) {
        return rotate_right(node);
    }
    
    // �� ��尡 ������ �ڽ��� �����ʿ� �߰��Ǿ��ٸ� RRŸ��
    if (balance < -1 && key > node->right->key) {
        return rotate_left(node);
    }
    
    // ���ο� ��尡 ���� �ڽ��� �����ʿ� �߰��Ǿ��ٸ� LRŸ��
    if (balance > 1 && key > node->left->key) {
        node->left = rotate_left(node->left);
        return rotate_right(node);
    }
    
    // ���ο� ��尡 ������ �ڽ��� ���ʿ� �߰��Ǿ��ٸ� RLŸ��
    if (balance < -1 && key < node->right->key) {
        node->right = rotate_right(node->right);
        return rotate_left(node);
    }
    
    return node;	// ���ο� ��Ʈ�� ��ȯ
}

// ���� ��ȸ �Լ�
void preorder(AVLNode *root)
{
    if (root != NULL)
    {
        printf("[%d] ",root->key);
        preorder(root->left);
        preorder(root->right);
    }
}

int main()
{
    AVLNode *root = NULL;

    // ���� Ʈ�� ����
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 29);

    printf("���� ��ȸ ���\n");
    preorder(root);

    return 0;
}