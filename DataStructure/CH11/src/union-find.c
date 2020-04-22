#define MAX_VERTICES 100

int parent[MAX_VERTICES];   // �θ� ���

void set_init(int n)        // �ʱ�ȭ
{
    for (int i = 0; i < n; i++) {
        parent[i] = -1;
    }
}

// curr�� ���ϴ� ������ ��ȯ
int set_find(int curr)
{
    if (parent[curr] == -1) {
        return curr;            // ��Ʈ
    }
    while (parent[curr] != -1) curr = parent[curr];
    return curr;
}

// �ΰ��� ���Ұ� ���� ������ ��ģ��.
void set_union(int a, int b)
{
    int root1 = set_find(a);    // ��� a�� ��Ʈ�� ã�´�.
    int root2 = set_find(b);    // ��� b�� ��Ʈ�� ã�´�.
    if (root1 != root2) {       // ���Ѵ�.
        parent[root1] = root2;
    }
}