//Program to implement Quick Sort

import java.io.*;

class QuickSort
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
 		qsort(a,0,n-1);
 		System.out.println("The sorted array of elements is as follows: ");
 		for (int i =0 ; i<n ;i++)
 		{
 			System.out.print(a[i]+ "\t");
 		}
 	}

 	static void qsort(int a, int lb, int ub)
 	{
 		int i,j,temp,key;
 		boolean flag = true;

 		if(lb<ub)
 		{
 			i = lb;
 			j = ub;
 			key = a[lb];

 			while(flag)
 			{
 				i++;
 				while((i<=ub) && (a[i] < key))
 				{
 					i++;
 				}
 				while((j>=lb) && (a[j] > key))
 				{
 					j--;
 				}
 				if(i<j)
 				{
 					temp = a[i];
 					a[i] = a[j];
 					a[j] = temp;
 				}
 				else
 				{
 					flag = false;
 				}
 			}
 			temp = a[j];
 			a[j] = a[lb];
 			a[lb] = temp;
 			qsort(a, lb, j-1);
 			qsort(a, j+1, ub);
 		}
 	}
}