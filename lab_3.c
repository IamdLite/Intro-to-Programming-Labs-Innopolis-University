#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define N 1000

//Task 1: Finding the strongest number in a given input  range


//First find factorial
char counted[100];

int factorial(int number){

int fact= 1;

    for (int i=1; i<=number; i++){
        fact*= i;
    }

    return fact;
}

_Bool is_strong_number(int number){

    int temp=number, sum=0, digit;

    while (temp != 0){

        digit = temp%10;
        sum += factorial(digit);
        temp /= 10;
        
    }
    bool res = (sum == number) ? true:false; 
    return res;

}

void find_strong_numbers_in_range(int lower_number, int upper_number){

    int range[upper_number];
    int s_index = 0;
    int strong_numbers[100];

    for (int i=lower_number; i<=upper_number; i++){

        if(is_strong_number(i)){

            strong_numbers[s_index] = i;
            s_index++;

        }

    }

printf("The strong numbers found from %d to %d are: ", lower_number, upper_number);

    printf("{");

    for(int i=0; i<s_index; i++){

        printf("%d,\t", strong_numbers[i]);

    };

    printf("}");

}

_Bool was_counted(char letter, char input[]){

     
     bool result;

            for(int i=0; i<strlen(input); i++){

                if(letter != counted[i]){

                    result == true;

                }

                else{

                    counted[i] = letter;
                    result = false;

                } 

            }

            return result;

}

//Task 2

void histogram_letters_frequency(char input[]){

   
   
    int max_freq = 0, count=0;
    int freq[26] = {0};
    char letters[26], current;

    for (int i=0; i<strlen(input); i++){
         count = 0;
         current=input[i];


        //Convert to lower case letters
        if(input[i] >= 'A' && input[i] <= 'Z'){
                current+=32; 
            }

        //Count letters
         if (((current >= 'a' && input[i] <= 'z'))) {

            freq[current-'a']++;

            if(freq[current-'a'] > max_freq){
                max_freq = freq[current-'a'];
            }
        
        }

    }

      //Store letters for reference
        for(int i=0; i<26; i++){
            letters[i] = 'a' + i;
        }
    
     //Sort letters in descending order
     for(int i=0; i<25; i++){
        for(int j=i+1; j<26; j++){
            if(freq[i] < freq[j]){
               
                int temp=0;
                temp = freq[i];
                freq[i] = freq[j];
                freq[j] = temp; 


            //sorting the letters as well
            char temp_letter = letters[i];
            letters[i] = letters[j];
            letters[j] = temp_letter;
            }


        }
     }

     //Output frequency histogram
     for(int i=0; i<26; i++){
        if(freq[i] > 0){
             printf("%c ", letters[i]);  
        }
     }
     printf("\n");


     //decrement the rowS value after each line
     for(int rowS=1; rowS<=max_freq;  rowS++){
        //enumerate the letters' frequencies
        for(int i=0; i<26; i++){
            //check letter occurence
            if(freq[i] > 0){
                //print . if the current letter's is greater than or equal to the rowS size
                if(freq[i] >= rowS){
                    printf(". ");
                }
                else printf(" ");
            }
            
        }
        printf("\n");
        
     }

     
}

//Task 3

void brute_force_password_Cracker(char password[]){

    char guess[100];
    int matched_chars = 0;

    //Get ASCII characters

    for(int i=0; i<strlen(password); i++){
        for(int j=0; j<=255; j++){
            if(password[i] == j){
                guess[i] = j;
                matched_chars++;
            }
        }
    }

    if(strlen(password) == matched_chars){
        printf("The password is: %s\n", guess);
    }
    else printf("Something went wrong\n");
}

void find_length_string(char word[]){

    char *test_input = word;

    char *ptr = test_input;
    int length =0;

  
        while(*ptr++) length++;

    printf("The length of the string %s is: %d\n", word, length);
}

//TAsk 4

void pyramid_of_numbers(int length){
    int number = 1;

    for(int i=0; i<length; i++){

        for(int j=0; j<length-i-1; j++){
            printf(" ");
        }

    for(int rowS=0; rowS < i+1; rowS++){
        printf("%d", number);
        number++;

    }
    printf("\n");
    }
}

//Task 5
void remove_duplicates(int n){
     int a[N];
     memset(a,0, N*sizeof(a[0]));

    for (int i =0; i < n; i++) {
        int input;
        scanf("%d", &input);

        //check if input is within valid range
        if (input < 0 || input > N) {
            printf("Invalid input\n");
            continue;
        }

        //only mark a number if it is not already counted
        if(a[input]==0){
            printf("%d", input);
            a[input]++; //mark as seen
        }
    
}
printf("\n ");
}

void custom_strcpy(char *src, char *dest){

    char *newline = strchr(src, '\n');
    if(newline){
        *newline = '\0';
    }

    char *str1 = src, *str2 = dest;

    while(*str2++ = *str1++);

    printf("The copied string is: %s\n", dest);

    

}

//Exercise 4: Populate two dimensional arrays with pointers
#define ROWS 3
#define COLUMNS 3

void get_2d_array(int matrix[][COLUMNS], int rows, int columns){
    for(int i=0; i<ROWS; i++){
        for(int j=0; j<ROWS; j++){
            printf("Enter the element %d%d in the matrix. \n", i+1, j+1 );
            scanf("%d", *(matrix + i) + j);
        }
    }

}

void print_2d_array(int matrix[][COLUMNS], int rows, int columns){
    for(int i=0; i<ROWS; i++){
        for(int j=0; j<COLUMNS; j++){
            printf("%d ", *(*(matrix + i) +j));
            
        }
        printf("\n");
    }

}

int main(){

int a[] = {1, 2, 3, 2, 4, 4};

//flash test





    int number1, number2, choice;


    printf("Welcome to lab 3, which one would you try first ?\n1-Find strong numbers in any range.\n2-Histogram of letters in a sentence\n3-Let's guess your password\n4-String length with pointers\n5-Generate triangle of numbers\n6-Remove duplicates in sets of numbers\n7-Try out our custom strcpy function\n8-Print arrays using pointers");
    scanf("%d", &choice);

    switch (choice)
    {
    case 1:
        printf("Yay! Enter the lower bound of the range: ");
        scanf("%d", &number1);
        printf("Yay! Enter the upper bound of the range: ");
        scanf("%d", &number2);
        find_strong_numbers_in_range(number1, number2);
        break;
    
    case 2:
    char input[100];
        printf("Write a sentence: ");
        scanf(" %[^\n]",  &input);
        histogram_letters_frequency(input);
        break;
    
    case 3:
    char password[100];
        printf("Enter the password: ");
        scanf("%s", &password);
        brute_force_password_Cracker(password);
        break;
    
    case 4:
    char word[100];
    printf("Give us the word: ");
    scanf("%s", &word);
    find_length_string(word);
    break;

    case 5:
    int height;
    printf("Enter the pyramid height ");
    scanf("%d", &height);
    pyramid_of_numbers(height);
    break;

    case 6:
    int number;
    printf("Enter the number of elements: ");
    scanf("%d", &number);
    remove_duplicates(number);
    break;

    case 7:
    char src[100], dest[100];
    printf("Enter the string to copy: ");
    
    //scanf("%*[^\n]%*c", &src);
    /* Problem: fgets doesn't wait for input. 
    From  stackoverflow, learned that it is due to a prior
    scanf that read a value but didm't read the newline*/

    //fix
    int c;
    while ( (c = getchar()) != EOF && c != '\n') { }
    // fgets(src, 100, stdin);
    fgets(src, 100, stdin);
    custom_strcpy(src, dest);
    break;

    case 8: 
    int matrix[ROWS][COLUMNS];
    get_2d_array(matrix, ROWS, COLUMNS);
    print_2d_array(matrix, ROWS, COLUMNS);
    break;
    
    default:
        break;
    }

return 0;
}



// int main(){
//     int a=1, *ap =&a;
//     int b=2, *bp=&b;

//     int *temp = ap;
//     ap =bp;
//     bp= temp;

//     printf("%d%d%d%d\n", a, *ap, b,*bp);

//     return 0;


// }