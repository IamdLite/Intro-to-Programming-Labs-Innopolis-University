#include <stdio.h>
#include <string.h>


char string_reverser(char string[]){

    size_t length = strlen(string);


    printf("%d", length);
    char reverse_char;

    // for(int i= length-1; i==0; i--){
    //     int j = 0;

    //     reverse_char = string[i];

    // }

return reverse_char;

}
void main(){

char user_char;

printf("Enter a string to reverse: ");
scanf("%s", &user_char);

printf("The reversed character is: %s", string_reverser(user_char));

return 0;

}