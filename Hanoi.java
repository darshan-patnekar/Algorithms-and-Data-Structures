//Towers of Hanoi problem

import java.io.*;
class Hanoi
{
	public void hanoi(int n, int a, int b, int c)
	{
		if(n>0)
		{
			hanoi(n-1,a,c,b);
			System.out.println("Move disk from "+a+"to "+b);
			hanoi(n-1,c,b,a);
		}
	}

	public static void main(String args[]) throws IOException
	{
		int n;
		Hanoi h = new Hanoi();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many disks: ");
		n = Integer.parseInt(br.readLine());
		h.hanoi(n,1,3,2);

	}
}