#include<stdio.h>
#include <string.h>
void draw_isoceles_triangle(int height){

//outer function to print numbers of rows(height)
    for(int i=0; i<height; i++){

        //first inner function to print spaces (n-i-1)
        //creates triangular shape by pushing stars forward
        for(int j=0; j<height-i-1; j++){
            printf(" ");
        }

        //second inner function to print stars 
        for(int k=0; k<2*i+1; k++){
            printf("*");

        }
        printf("\n");
    }
    
}

void draw_rectangle(int length, int width){

    for(int i=0; i<width; i++){
        for(int j=0; j<length; j++){

            if(i != 0 || i!=width-1){
                printf("*");
                for(int k=0; k<width-2; k++){
                    printf(" ");
                }
                printf("*");
            }
           else  printf("*");

        }
        printf("\n");
    }
}

void draw_right_angle_triangle(int height){

    for(int i=0; i<height; i++){
        for(int j=1; j<i+1; j++){
            printf("*");
        }
        printf("\n");
    }
}

void draw_kite(int size){

    draw_right_angle_triangle(size);
     for(int i=0; i<size; i++){
        for(int j=size; j>i+1; j--){
            printf("*");
        }
        printf("\n");
    }

}

void draw_circle(int radius){

}

void reverse_string(char input[]){


    int input_size = strlen(input);
    printf("Input size: %d\n", input_size);
    char reversed_input[input_size];

    for(int i=input_size; i>=0; i--){
        
        reversed_input[input_size - i] = input[i-1];
        printf("input size - i is %d and input is %c\n", input_size-i, *(input+i));
    }

    printf("Your reversed input is %s", reversed_input);
}

void swap_integers(int first_integer, int second_integer){

    printf("First integer is %d and second integer is %d before swapping\n", first_integer, second_integer);

    int temp = second_integer;
    second_integer = first_integer;
    first_integer = temp;

    
    printf("First integer is %d and second integer is %d after swapping\n", first_integer, second_integer);

}

void write_to_file(char text[]){

    FILE *fileAddress;

    fileAddress = fopen("results.txt", "w");

    if(fileAddress != NULL){
        for(int i=0; i<strlen(text); i++){
            fputc(text[i], fileAddress);
        }
        printf("\nFile wriiten successfully to your current directory (results.txt) !");
        fclose(fileAddress);
    }
    
    else printf("Something went wrong)");

    }
    
   







int main(void){

    int choice;
    int height, length, first, second, width = 0;
    char input_to_reverse[]="";

    printf("Choose the  shape you want to draw:\n0-Reverse a string\n1-Isoceles Triangle\n11-Right angle triangle\n2-Rectangle\n3-Circle\n4-Skull\n5-Kite\n6-Boring( prefer to swap integers\n7- Write to text file\n");
    scanf("%d", &choice);

    if (choice == 1){
        printf("Enter the height: ");
        scanf("%d", &height);
        draw_isoceles_triangle(height);
    }
    else if (choice == 2){
        printf("Enter the length: ");
        scanf("%d", &length);
        printf("Enter the width: ");
        scanf("%d", &width);
        draw_rectangle(length, width);
    }
     else if (choice == 11){
        printf("Enter the height of the right angle triangle: ");
        scanf("%d", &height);
        draw_right_angle_triangle(height);

    }
    else if (choice == 5){
        printf("Enter the size of the kite: ");
        scanf("%d", &height);
        draw_right_angle_triangle(height);

    }
    else if (choice == 6){
        printf("Enter the first integer: ");
        scanf("%d", &first);
        printf("Enter the second integer: ");
        scanf("%d", &second);
        swap_integers(first, second);

    }
    else if (choice == 0){
        printf("Enter the input to reverse: ");
        scanf("%s", &input_to_reverse);
        reverse_string(input_to_reverse);
        
    }
    else if (choice == 7){
        printf("Write a text to file: ");
        scanf(" %[^\n]s", &input_to_reverse);
        write_to_file(input_to_reverse);
        
    }
    else printf("Wrong choice/)");

getchar();
return 0;
}