#include <stdio.h>
#include <string.h>


#define BASE_YEAR 1900


union IP{

    unsigned int raw;

    struct Packet {

        unsigned short version: 4;
        unsigned short IHL: 4;
        unsigned short DSCP: 6;
        unsigned short ECN: 2;
        unsigned short totalLength: 16;
    } packet;
};

int main(){

    struct birthday{

        unsigned short day: 5;
        unsigned  short month: 4;
        unsigned short year: 7;

    };

//     struct birthday a;

//     a.day = 25;
//     a.month = 6;
//     a.year = 2024-BASE_YEAR;

//     printf("Birthday is %u %u %u\n", a.day, a.month, BASE_YEAR+a.year);
//     printf("%d", sizeof(struct birthday));



// union  IP ip;

// printf("Enter the address: ");
// scanf("%x", &ip.raw);

// printf("%u\n%u\n%u\n%u\n%u", ip.packet.version, ip.packet.IHL, ip.packet.DSCP, ip.packet.ECN, ip.packet.totalLength );

// enum weekdays{

//     Monday = 1,
//     Tuesday,
//     Wednesday,
//     Thursday,
//     Friday,
//     Saturday,
//     Sunday

// } weekday;

// int input; 

// printf("Enter a week day number: ");
// scanf("%d", &input);
// switch (input){

//     case Monday:
//     printf("The day is Monday\n");
//     break;

//     case Tuesday:
//     printf("The day is Tuesday\n");
//     break;

//     case Wednesday:
//     printf("The day is Wednesday\n");
//     break;

//     case Thursday:
//     printf("The day is Thursday\n");
//     break;

//     case Friday:
//     printf("The day is Friday\n");
//     break;

//     case Saturday:
//     printf("The day is Saturday\n");
//     break;

//     case Sunday:
//     printf("The day is Sunday\n");
//     break;

//     default:
//     printf("Invalid day");

// }


//exercise 4

typedef struct {
    char recipe_name[10][20];
    char ingredients[10][10];
    int  ingredients_size;
    int  ingredients_amount[10];
} Recipes;

int number_recipes, number_ingredients;

printf("\nEnter number of recipes: ");
scanf("%d", &number_recipes);


Recipes Cookbook[number_recipes];

for(int i=0; i<number_recipes; i++){
    Recipes recipe;

    printf("\nEnter the %d recipe: ", i+1);
    scanf("%s", &recipe.recipe_name);

    A:
    printf("\nEnter the amount of ingredients in the range 2-10: ");
    scanf("%d", &number_ingredients);

if (number_ingredients < 2 && number_ingredients > 10){
    printf("Wrong Input!\n"); goto A; } else goto B;

    B:
    recipe.ingredients_size = number_ingredients;
    for(int j=0; j<number_ingredients; j++){
        printf("\nEnter the %d ingredient of %s: ", j+1, recipe.recipe_name);
        scanf("%s", &recipe.ingredients[j]);
        printf("\nEnter the amount of %s needed: ", recipe.ingredients[j]);
        scanf("%d", &recipe.ingredients_amount[j]);
    }
    Cookbook[i] = recipe;

}

    printf("=======COOKBOOK========");
for(int i=0; i<number_recipes; i++){
    

    printf("\nThe %d recipe is %s\n", i+1, Cookbook[i].recipe_name);
    printf("\nINGREDIENTS REQUIRED\n");
    for(int j=0; j<Cookbook[i].ingredients_size; j++){

        printf("%s: %d units\n", Cookbook[i].ingredients[j],Cookbook[i].ingredients_amount[j]);

    }

}

}


    