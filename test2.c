#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <stdalign.h>

// union U{

// uint32_t x;
// char s1[5];

// struct a{
//     char s2[2];
//     int16_t z;
// }__attribute__((packed));

// };

typedef struct{
    unsigned char (*ptr)[10];
    uint32_t z;
} s1;

typedef struct{
    char (*ptr)[11];
    int32_t z;
} s2;

typedef struct {
    char *p;
    int32_t z;
} s3;

int f(){
    static int16_t n =5;
}
int go(s3 s3){


}

int comp(){
    static int x =5;
    static int y=5;
    while(y<=6 && x<=6){
        x++;
        y++;
        comp();
    }
    return x+y;
}


int main(){

    

    int array[100];

    for(int i=0; i <50; i++){
        array[i]=i;
    }

    static int32_t x = 5;

    int arr[] = {1, 2, 3, 4};
    int *p = arr;
    int **pp = &p;
    *(*pp+1) = 20;
    printf("%d \n", comp());


/*
    printf("%lld\n", sizeof(array));
    double A[5];
    for (int i=0; i<5; ++i)
    *(A+i) = i;
    for(int i=1; i<=5; i++)
    A[i-1] = (i>1 ? A[i-1] : 1) * A[i-1];
    s3 s3;
    printf("s1: %lu s2: %zu s3: %zu pointer: %zu", sizeof(s1), sizeof(s2), sizeof(s3), sizeof(s3.z));
 */
}