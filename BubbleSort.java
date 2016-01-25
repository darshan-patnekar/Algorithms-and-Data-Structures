//Program to implement bubble sort

import java.io.*;
class BubbleSort
{
 	public static void main(String[] args) 
 	{
 		int n;
 		int[] a = new int[50];
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		System.out.println("How many numbers are to be sorted");
 		n = Integer.parseInt(br.readLine());
 		System.out.println("Enter the numbers");
 		for (int i=0;i <n; i++)	
 		{
 			a[i] = Integer.parseInt(br.readLine());
 		}
 		bubbleSort(a,n);
 		System.out.println("The sorted array of elements is as follows: ");
 		for (int i =0 ; i<n ;i++)
 		{
 			System.out.print(a[i]+ "\t");
 		}
 	}

 	public void bubbleSort(int a[], int n)
 	{
 		int pass, temp;
 		boolean switched = true;
 		for (int pass=1; pass < n && switched; pass++)
 		{
 			switched = false;
 			for(j=0; j<n-pass; j++)
 			{
	 			if(a[j]>a[j+1])
	 			{
	 				switched = true;
	 				temp = a[j];
	 				a[j]= a[j+1];
	 				a[j+1] = temp;

	 			}
 			}
 		}
 	}
}