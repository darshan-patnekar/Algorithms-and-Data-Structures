package fibonacci;

import java.util.Scanner;

public class Fibonacci 
{
	 
    @SuppressWarnings("resource")
    public static void main(String args[]) 
    {
 
        
        System.out.print("Enter number upto which Fibonacci series to print: ");
        int number = new Scanner(System.in).nextInt();
 
        System.out.println("\n\nFibonacci series upto " + number +" numbers : ");
        
        
        for(int i=1; i<=number; i++)
        {
            System.out.print(fibonacciLoop(i)+" ");
        }
    } 

    
    public static int fibonacciRecusion(int number)
    {
        if(number == 1 || number == 2)
        {
            return 1;
        }
 
        return fibonacciRecusion(number-1) + fibonacciRecusion(number -2); //tail recursion
    }


 
    // Java program for Fibonacci number using Loop.
    public static int fibonacciLoop(int number)
    {
        if(number == 1 || number == 2)
        {
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=0;
        for(int i= 3; i<= number; i++)
        {
            fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = fibonacci;
 
        }
        return fibonacci; //Fibonacci number
    }
}