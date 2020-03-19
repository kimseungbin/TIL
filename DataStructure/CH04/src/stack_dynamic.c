#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

typedef int elemnet;
typedef struct {
    elemnet *data;      // data은 포인터로 정의된다.
    int capacity;       // 현재 크기
    int top;
} StackType;

// 스택 생성 함수
void init_stack(StackType *s)
{
    s->top = -1;
    s->capacity = 1;
    s->data = (elemnet *)malloc(s->capacity * sizeof(elemnet));
}
// 공백 상태 검출 함수
int is_empty(StackType *s)
{
    return (s->top == -1);
}
// 포화 상태 검출 함수
int is_full(StackType *s)
{
    return (s->top == (s->capacity - 1));
}
// 삽입함수
void push(StackType *s, elemnet item)
{
    if (is_full(s)) {
        s->capacity *= 2;
        s->data = (elemnet *)realloc(s->data, s->capacity * sizeof(elemnet));
    }
    s->data[++(s->top)] = item;
}
// 삭제함수
elemnet pop(StackType *s)
{
    if (is_empty(s)) {
        fprintf (stderr, "스택 공백 에러\n");
        exit(1);
    }
    else return s->data[(s->top)--];
}

int main()
{
    StackType s;
    init_stack(&s);
    push(&s, 1);
    push(&s, 2);
    push(&s, 3);
    printf("%d \n", pop(&s));
    printf("%d \n", pop(&s));
    printf("%d \n", pop(&s));
    free(s.data);
    return 0;
}