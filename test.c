
#include <stdio.h>
#include <stdlib.h>



int main (){
int n = 0 ;

printf("Enter the number of rows\n");

scanf("%d",&n);

char *** szData = (char *** )malloc(n * sizeof(char ** )) ;

//Allocate memroy for each row

for(int i = 0 ; i < n ; i++ )
{ 
    szData[i] = (char ** ) malloc(2 * sizeof(char * )) ;
    for ( int j = 0 ; j < 2 ; j++ )
    { 
        szData[i][j] = (char *) malloc (25 * sizeof(char));
    }
 }

 //Assign some data

 for( int i = 0 ; i < n ; i++ )
 { 
    sprintf(szData[i][0],"string%d", i); 
    sprintf(szData[i][1],"string1%d", i);
 }

 //print all the elements

 for( int i = 0 ; i < n ; i++ ) 
 { 
    printf("%s\n",szData[i][0]);
    printf("%s\n",szData[i][1]);
 } 

 //free memory here
 for(int i = 0 ; i < n ; i++ )
 {  
    for ( int j = 0 ; j < 2 ; j++ )
    { 
        free(szData[i][j]);
    } 
 }

 for(int i = 0 ; i < n ; i++ )
 {  
    free(szData[i]);
 }

 free(szData);
}