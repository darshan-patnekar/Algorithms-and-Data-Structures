package kary;

public class Kary {
	
	int[] A = new int[4];
	public void kary(int n, int k)
	{
		
		if (n < 1)
		{
			for(int i = 0; i<A.length;i++)
			System.out.print(A[i]);
			System.out.print(" ");
		}
		else
		{
			for (int j=0 ; j<k; j++)
			{
				A[n-1] = j;
				kary(n-1, k);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int n = 4;
		int k = 4;
		Kary k1 = new Kary();
		k1.kary(n,k);
	}
}

