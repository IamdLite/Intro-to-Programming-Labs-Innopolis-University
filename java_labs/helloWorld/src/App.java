import java.io.*;
import java.util.Scanner;
import java.util.Random;






public class App {

    static class Time{
        int seconds;
        int minutes;
        int hours;

        public Time(int hours, int minutes, int seconds){
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }
    }
    
    public static void swapNumbers(){
    
        //scanner object to read input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();
        scanner.close();
        
        System.out.println("Before swapping: First number is " + firstNumber + " and second number is " + secondNumber);
        
        //swapping
        int temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;
    
        System.out.println("After swapping: First number is now " + firstNumber + " and second number is now" + secondNumber);
    }

    public static void findASCIIValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char character = scanner.next().charAt(0);
        System.out.println("The ASCII value of " + character + " is " + (int)character);
        scanner.close();
    }

    public static void getAlphabetIndex(){
        System.out.println("Enter a letter in the english alphabet: ");
        Scanner scanner  = new Scanner(System.in);
        char letter = scanner.next().charAt(0);
        int index = (int)letter - 96;
        System.out.println("The index of " + letter + " in the English alphabet is " + index);
        scanner.close();
    }

    public static void compareStrings(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String firstString = scanner.next();
        System.out.println("The second string: ");
        String secondString = scanner.next();

        if(firstString.equals(secondString)){
            System.out.println("The strings are equal.\n");}
        else System.out.println("The strings are not equal.");
        scanner.close(); 

    }
    
    public static void countVowels(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a vowel-full word so we can coun it for you: ");
        String inputWord = scanner.next();

        int vowelCount = 0;
        for(char c : inputWord.toCharArray()){
            if ("AEIOUaeiou".indexOf(c) != -1){
                vowelCount++;
            }
        }

        System.out.println("The word has " + (int)vowelCount + " vowels" + " and containe " + inputWord.length() + " letters in total.");
        scanner.close();
    }   

    public static void convertTemperature(){
        
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter the temperature in degrees Fahrenheit: ");   
         float input = scanner.nextInt(); 
         float tempCelsuis = (input - 32)*5/9; 
         System.out.println("The temperature in degrees Celcius is: " + tempCelsuis);
         scanner.close();

    }

    public static Time difference(Time start, Time stop){
        Time diff = new Time(0,0,0);
        if(start.seconds > stop.seconds){
            --stop.minutes;
            stop.seconds += 60;
        }
        diff.seconds = stop.seconds - start.seconds;
        if(start.minutes > stop.minutes){
            --stop.hours;
            stop.minutes += 60;
        }
        diff.minutes = stop.minutes - start.minutes;
        diff.hours = stop.hours - start.hours;
        return(diff);
    }

    public static void convertToBases(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Binary: " + Integer.toBinaryString(number));
        System.out.println("Decimal: " + number);
        System.out.println("Hexadecimal: " + Integer.toHexString(number));
        scanner.close();
    }

public static void calculateAverage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the numbers of values to computer the average for: ");
        int arraySize = scanner.nextInt();
        int[] numbers = new int[arraySize];
        float sum=0;
        for(int i=0; i<arraySize; i++){
            System.out.println("Enter the " + i + " value: ");
            numbers[i] = scanner.nextInt();
            sum+=numbers[i];
        }
        System.out.println("The average is " + sum/arraySize);
        scanner.close();
        
}

public static void insertIntoArray(){
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    int[] array = new int[6];
    for(int i=0; i<6; i++){
        array[i] = rand.nextInt();
        System.out.printf("{%d,\t", array[i]);
    }
    System.out.printf("}\n");

    System.out.println("Enter the number to insert in a 6 integers array: ");
    int number = scanner.nextInt();
    System.out.println("Enter the position where you want it inserted: ");
    int position = scanner.nextInt();

    array[position] = number;

    System.out.println( number + " was inserted successfuly at position "+ position);
    for(int i=0; i<6; i++){
        array[i] = rand.nextInt();
        System.out.printf("{%d,\t", array[i]);
        
    }
    System.out.printf("}\n");
    scanner.close();

} 

public static void findDuplicates(){

    int[] array = {1, 2, 3, 4, 5, 6, 6, 8, 2};
 
    for(int i=0; i<array.length;i++){
        int count = 1;
        for(int j=i+1; j<array.length; i++){
            if(array[i] == array[j]){
            count++;
            System.out.println(array[i] + " occurs " + count  + " times");
            }   
        }
    }
}

public static void checkFileDirectory(){

    System.out.println("Enter the directory")
}


    public static void main(String[] args) throws Exception {
        //scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        //main menu
        System.out.println("Hello, World!");
        System.out.println("Which exercise would you like to run first?\n1. Swap numbers\n2. Find ASCII value of a character\n3. Get index of all characters in English alphabet\n4. Compare two strings lexicographically\n5. Count all vowels in a string\n6. Convert temperature from Fahrenheit to Celcisus degrees\n7. Calculate the difference between two time periods\n8. Convert to binary, decimal and hexadecimal\n9. Calculate average of array integer elements\n10. Insert stuff into a position in an array\n11. Find duplicate values in array integer values\n12. Check whether file or directory exists\n13. Check if pathname s a file or directory\n14. Read and output data from text file\n");
        int userOption = scanner.nextInt();
        switch(userOption){
        case 1:
            swapNumbers();
            break;
        case 2:
            findASCIIValue();
            break;
        case 3: 
            getAlphabetIndex();
            break;
        case 4:
            compareStrings();
            break;
        case 5:
            countVowels();
            break;
        case 6:
            convertTemperature();
            break;
        case 7:
            Time start = new Time(8, 12, 15);
            Time stop = new Time(12,34,55);
            Time diff;
            
            //difference method
            difference(start, stop);
            System.out.printf("Time difference: %d:%d:%d -", start.hours, start.minutes, start.seconds);
            System.out.printf(" %d:%d:%d ", stop.hours, stop.minutes, stop.seconds);
            System.out.printf("= %d:%d:%d\n", diff.hours, diff.minutes, diff.seconds);
            break;
        case 8:
            convertToBases();
            break;
        case 9:
            calculateAverage();
            break;
        case 10:
            insertIntoArray();
            break;
        case 11:
            findDuplicates();
            break;
        case 12:
            checkFileDirectory();
            break;
        case 13:
            checkPath();
            break;
        case 14:
            readTextFile();
            break;
        default:
            System.out.println("Invalid option. Please try again.");
            break;
    }
        
        
        


    }

    public static double temperatureConverter(double celsius){
        return (celsius * 9/5) + 32;
    }
}
