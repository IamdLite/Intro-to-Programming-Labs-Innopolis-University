#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>


// typedef struct{

//     char name[15];
//     char surname[15];
//     int  group_number;

// } student;

// typedef struct {
//     char day[10];
//     int year;
//     char month[10];
// } days;


// int main(){

//     student student;
//     days day;

// printf("Enter your name: ");
// scanf("%s", &student.name);
// printf("\nEnter your surname: ");
// scanf("%s", &student.surname);
// printf("\nEnter your group number: ");
// scanf("%d", &student.group_number);
// printf("\nEnter the exam day: ");
// scanf("%s", &day.day);
// printf("\nEnter the exam year: ");
// scanf("%d", &day.year);
// printf("\nEnter the exam month: ");
// scanf("%s", &day.month);


// printf("\n Your name is %s, surname %s and group_number %d \nYour exam is on %s of %s %d ", student.name, student.surname, student.group_number, day.day, day.month, day.year);
// return 0;
// }

typedef union {
    unsigned long long encrypted_message;
    unsigned long long decrypted_message;
} lockbit;

int main(){

    lockbit lockbit;
    printf("Enter your message: ");
    scanf("%ul", &lockbit.decrypted_message);

    for(int i=0; i<sizeof(lockbit.decrypted_message); i++){
        printf("%d", i++);
    }
    return 0;
}