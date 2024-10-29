#include <stdio.h>
#include <stdlib.h>



int* f(int p)
{
int* ptr = (int*)malloc(2*sizeof(int));
*ptr = p;
*(ptr+1) = p*p;
return ptr;
}

struct S
{
int a, b;
} s = { .a = 7, .b = 77 };


int main(){
    // int* result = f(5);
    // int res = (&s)->a + (&s)->b;
    // for(;;)/ int g;
    // printf("%d", res);

    int a=1, b=2;
    int *pa = &a;
    int *pb =&b;
    pa =pb;
    pb = pa;
    printf("%d %d", a, b);
}