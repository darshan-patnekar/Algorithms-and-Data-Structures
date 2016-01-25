//Program to print n bit binary numbers

class Binary
{
	int[] A = new int[2];
	public void binary(int n)
	{
		if(n<1)
		{
		    for (int i=0 ;i<2;i++)
			System.out.print(A[i]);
			System.out.print(" ");
		}
		else
		{
			A[n-1] = 0;
			binary(n-1);
			A[n-1] = 1;
			binary(n-1);
		}
	}

	public static void main(String[] args) 
	{
		Binary b = new Binary();
		b.binary(2);	
	}
}
