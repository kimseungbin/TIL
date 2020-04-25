#include <stdio.h>
#include <stdlib.h>
#define MAX(a, b) ( (a) > (b) ? (a) : (b) )

// AVL 트리 노드 정의
typedef struct _AVLNode {
    int key;
    struct _AVLNode *left;
    struct _AVLNode *right;
} AVLNode;

// 트리의 높이를 반환
int get_height(AVLNode *node)
{
    int height = 0;
    
    if (node != NULL) {
        height = 1 + MAX(get_height(node->left), get_height(node->right));
    }
    
    return height;
}
// 노드의 균형인수를 반환
int get_balance(AVLNode *node)
{
    if (node == NULL) return 0;
    
    return get_height(node->left) - get_height(node->right);
}

// 노드를 동적으로 생성하는 함수
AVLNode* create_node(int key)
{
    AVLNode* node = (AVLNode*)malloc(sizeof(AVLNode));
    node->key = key;
    node->left = NULL;
    node->right = NULL;
    return node;
}

// 오른쪽으로 회전시키는 함수
AVLNode* rotate_right(AVLNode *parent)
{
    AVLNode* child = parent->left;
    parent->left = child->right; // 부모노드의 왼쪽에 자식노드의 오른쪽 노드를 연결하고
    child->right = parent;		// 자식노드의 오른쪽에 부모노드를 연결시킨다.
    // 새로운 루트를 반환
    return child;
}

// 왼쪽으로 회전시키는 함수
AVLNode* rotate_left(AVLNode *parent)
{
    AVLNode* child = parent->right;
    parent->right = child->left; // 부모노드의 오른쪽에 자식노드의 왼쪽 노드를 연결하고
    child->left = parent;		// 자식노드의 왼쪽에 부모노드를 연결시킨다.
    // 새로운 루트를 반환
    return child;
}

// AVL 트리에 새로운 노드 추가 함수
AVLNode* insert(AVLNode *node, int key)
{
    // 이진 탐색 트리의 노드 추가 수행
    if (node == NULL) {	// 탐색이 실패한 위치가 삽입 위치가 된다.
        return (create_node(key));
    }
    
    if (key < node->key) {
        node->left = insert(node->left, key);
    }
    else if (key > node->key) {
        node->right = insert(node->right, key);
    }
    else return node;	// 동일한 키는 허용되지 않음
    
    // 노드들의 균형인수 계산
    int balance = get_balance(node);
    
    // 새 노드가 왼쪽 자식의 왼쪽에 추가되었다면 LL타입
    if (balance > 1 && key < node->left->key) {
        return rotate_right(node);
    }
    
    // 새 노드가 오른쪽 자식의 오른쪽에 추가되었다면 RR타입
    if (balance < -1 && key > node->right->key) {
        return rotate_left(node);
    }
    
    // 새로운 노드가 왼쪽 자식의 오른쪽에 추가되었다면 LR타입
    if (balance > 1 && key > node->left->key) {
        node->left = rotate_left(node->left);
        return rotate_right(node);
    }
    
    // 새로운 노드가 오른쪽 자식의 왼쪽에 추가되었다면 RL타입
    if (balance < -1 && key < node->right->key) {
        node->right = rotate_right(node->right);
        return rotate_left(node);
    }
    
    return node;	// 새로운 루트를 반환
}

// 전위 순회 함수
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

    // 예제 트리 구축
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 29);

    printf("전위 순회 결과\n");
    preorder(root);

    return 0;
}