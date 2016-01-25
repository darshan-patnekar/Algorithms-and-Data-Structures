package reorder;

import java.util.Stack;

public class Reorder
{
	public static int[] reorderArray(int[] n) 
	{
		Stack<Integer> stk = new Stack<Integer>();
		int zeros = 0;
		
		for(int i =0 ; i<n.length;i++)
		{
			if(n[i] == 0)
			{
				zeros++;
				continue;
			}
			stk.push(n[i]);
		}
		for(int i = n.length-1; i>n.length-1-zeros; i--)
		{
			n[i] = 0;
		}
		
		for(int i = n.length-1-zeros; i>=0; i--)
		{
			n[i] = stk.pop();
		}
		
		return n;

	}
	
	public static void main(String [] args)
	{
		int[] n = new int[]{1, 0, 3, 4, 5, 0};
		n = reorderArray(n);
		for (int i= 0; i<n.length;i++)
		{
			System.out.print(n[i]);
		}
		
	}
}