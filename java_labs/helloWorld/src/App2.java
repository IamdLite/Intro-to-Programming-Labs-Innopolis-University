import java.io.*;
import java.util.Scanner;

class Calculator{
    float result;
    int firstNumber;
    int secondNumber;

    Calculator(){
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.result = 0;
    }

    Calculator(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber(){
        return this.firstNumber;
    }

    public int getSecondNumber(){
        return this.secondNumber;
    }

    public float getResult(){
        return this.result;
    }

    public void addNumbers(int firstNumber, int secondNumber){
        this.result = firstNumber + secondNumber;
    }

    public void subtractNumber(int firstNumber, int secondNumber){
        this.result = firstNumber-secondNumber;
    }

    public void multiplyNumbers(int firstNumber, int secondNumber){
        this.result =  firstNumber * secondNumber;
    }

    public void divideNumbers(float firstNumber, float secondNumber){
        if(secondNumber == 0){
            System.out.println("Divisor cannot be zero");
        } else {
        this.result   = (firstNumber/secondNumber); }
    }

}

public class App2 {
    
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello world");
        System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
        int option = scanner.nextInt();
        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();     
        scanner.close();

        Calculator calculator = new Calculator(firstNumber, secondNumber);


        switch(option){
            case 1:
                calculator.addNumbers(firstNumber, secondNumber);
                System.out.println("The result of " + calculator.getFirstNumber() + " + " + calculator.getSecondNumber() + " is " + (int)calculator.getResult());
                break;
                    
            case 2:
                calculator.subtractNumber(firstNumber, secondNumber);
                System.out.println("The result of " + calculator.getFirstNumber() + " - " + calculator.getSecondNumber() + " is " + (int)calculator.getResult());
                break;
            
            case 3:
                calculator.multiplyNumbers(firstNumber, secondNumber);
                System.out.println("The result of " + calculator.getFirstNumber() + " x " + calculator.getSecondNumber() + " is " + (int)calculator.getResult());
                break;   
            
            case 4:
                calculator.divideNumbers(firstNumber, secondNumber);
                System.out.println("The result of " + calculator.getFirstNumber() + " / " + calculator.getSecondNumber() + " is " + calculator.getResult());
                break;   
            
            default:
                System.out.println("Invalid option");

        }

  
        

    }
    
}
