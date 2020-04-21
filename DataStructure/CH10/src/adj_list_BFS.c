#include<stdio.h>
#include<stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_QUEUE_SIZE 10

typedef int element;
typedef struct {    // ť Ÿ��
    element queue[MAX_QUEUE_SIZE];
    int front, rear;
} QueueType;

// ���� �Լ�
void error(char *message)
{
    fprintf(stderr, "%s\n", message);
    exit(1);
}

// �ʱ�ȭ �Լ�
void init_queue(QueueType *q)
{
    q->front = q->rear = 0;
}

// ���� ���� ���� �Լ�
int is_empty(QueueType *q)
{
    return (q->front == q->rear);
}

// ��ȭ ���� ���� �Լ�
int is_full(QueueType *q)
{
    return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}


// ���� �Լ�
void enqueue(QueueType *q, element item)
{
    if (is_full(q)) {
        error("ť�� ��ȭ�����Դϴ�.");
    }
    q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
    q->queue[q->rear] = item;
}

// ���� �Լ�
element dequeue(QueueType *q)
{
    if (is_empty(q)) {
        error("ť�� ��������Դϴ�.");
    }
    q->front = (q->front + 1) % MAX_QUEUE_SIZE;
    return q->queue[q->front];
}

#define MAX_VERTICES 50
typedef struct _GraphNode {
    int vertex;
    struct _GraphNode *link;
} GraphNode;

typedef struct GraphType {
    int n;  // ������ ����
    GraphNode *adj_list[MAX_VERTICES];
} GraphType;


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

void bfs_list(GraphType *g, int v)
{
    GraphNode *w;
    QueueType q;

    init_queue(&q);         // ť �ʱ�ȭ
    visited[v] = TRUE;      // ���� v �湮 ǥ��
    printf("%d �湮 -> ", v);
    enqueue(&q, v);         // ���� ������ ť�� ����
    while (!is_empty(&q)) {
        v = dequeue(&q);    // ť�� �ִ� ���� ����
        for (w = g->adj_list[v]; w; w = w->link) {  // ���� ���� Ž��
            if (!visited[w->vertex]) {              // �̹湮 ���� Ž��
                visited[w->vertex] = TRUE;                  // �湮 ǥ��
                printf("%d �湮 -> ", w->vertex);
                enqueue(&q, w->vertex);             // �湮�� ������ ť�� ����
            }
        }
    }
}

int main()
{
    GraphType *g;
    g = (GraphType*)malloc(sizeof(GraphType));
    init(g);
    for (int i = 0; i < 6; i++) {
        insert_vertex(g, i);
    }
    insert_edge(g, 0, 4);
    insert_edge(g, 2, 3);
    insert_edge(g, 2, 1);
    insert_edge(g, 0, 2);
    insert_edge(g, 4, 5);
    insert_edge(g, 1, 5);

    printf("�ʺ� �켱 Ž��\n");
    bfs_list(g, 0);
    printf("\n");
    free(g);
    return 0;
}