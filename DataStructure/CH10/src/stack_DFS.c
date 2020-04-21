#include<stdio.h>
#include<stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 50
typedef struct _GraphNode {
    int vertex;
    struct _GraphNode *link;
} GraphNode;

typedef struct GraphType {
    int n;  // ������ ����
    GraphNode *adj_list[MAX_VERTICES];
} GraphType;
//
typedef int element;
typedef struct StackNode {
    element data;
    struct StackNode *link;
} StackNode;

typedef struct {
    StackNode *top;
} LinkedStackType;

int visited[MAX_VERTICES];

// �׷��� �ʱ�ȭ
void init(GraphType *g)
{
    int v;
    g->n = 0;
    for (v = 0; v < MAX_VERTICES; v++) {
        g->adj_list[v] = NULL;
    }
}

// ���� ���� ����
void insert_vertex(GraphType *g, int v)
{
    if (((g->n) + 1) > MAX_VERTICES) {
        fprintf(stderr, "������ ���� �ʰ�");
        return;
    }
    g->n++;
}

// ���� ���� ����, v�� u�� ���� ����Ʈ�� ����
void insert_edge(GraphType *g, int u, int v)
{
    GraphNode *node;
    if (u >= g->n || v >= g->n) {
        fprintf(stderr, "���� ��ȣ ����");
        return;
    }
    node = (GraphNode*)malloc(sizeof(GraphNode));
    node->vertex = v;
    node->link = g->adj_list[u];
    g->adj_list[u] = node;
}

// ���� �ʱ�ȭ �Լ�
void init_stack(LinkedStackType *s)
{
    s->top = NULL;
}
// ���� ���� ���� �Լ�
int is_empty(LinkedStackType *s)
{
    return (s->top == NULL);
}
// ��ȭ ���� ���� �Լ�
int is_full(LinkedStackType *s)
{
    return 0;
}
// ���� �Լ�
void push(LinkedStackType *s, element item)
{
    StackNode *temp = (StackNode *)malloc(sizeof(StackNode));
    temp->data = item;
    temp->link = s->top;
    s->top = temp;
}

void print_stack(LinkedStackType *s)
{
    for (StackNode *p = s->top; p != NULL; p = p->link) {
        printf("%d->", p->data);
    }
    printf("NULL \n");
}
// ���� �Լ�
element pop(LinkedStackType *s)
{
    if (is_empty(s)) {
        fprintf(stderr, "������ �������\n");
        exit(1);
    }
    else {
        StackNode *temp = s->top;
        element data = temp->data;
        s->top = s->top->link;
        free(temp);
        return data;
    }
}
// ��ũ �Լ�
element peek(LinkedStackType *s)
{
    if (is_empty(s)) {
        fprintf(stderr, "������ �������\n");
        exit(1);
    }
    else {
        return s->top->data;
    }
}

void dfs_stack(GraphType *g, int v)
{
    LinkedStackType s;
    init_stack(&s);
    push(&s, v);
    while (!is_empty(&s)) {
        v = pop(&s);
        if (!visited[v]) {
            visited[v] = TRUE;
            printf("���� %d -> ", v);
            for (GraphNode *w = g->adj_list[v]; w; w = w->link) {
                if (!visited[w->vertex]) {
                    push(&s, w->vertex);
                }
            }
        }
    }
}

int main()
{
    GraphType *g;
    g = (GraphType*)malloc(sizeof(GraphType));
    init(g);
    for (int i = 0; i < 4; i++) {
        insert_vertex(g, i);
    }
    insert_edge(g, 0, 1);
    insert_edge(g, 0, 2);
    insert_edge(g, 0, 3);
    insert_edge(g, 1, 2);
    insert_edge(g, 2, 3);

    dfs_stack(g, 0);
    printf("\n");
    free(g);
}