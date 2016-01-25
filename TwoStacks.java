//Implementing two stacks in an array

import java.io.*;
class StackOperations{
	
	private Object[] info;
	private int top1, top2;
	private Object item;
	public StackOperations(int capacity)
	{
		info = new Object[capacity];
		top1 = -1;
		top2 = capacity;
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void push(int ch) throws Exception
	{
		if(isFull(ch)==true)
		{
			System.out.println("Stack overflow!!");
		}
		else
		{
			System.out.println("Enter the element to be pushed: ");
			item = br.readLine();
			if(ch % 2 ==0)
			{
				top2--;
				info[top2] = item;
				System.out.println("Element pushed in stack 2");
			}
			else
			{
				top1++;
				info[top1] = item;
				System.out.println("Element pushed in stack 1");
				
			}
		}
	}

	public void pop(int ch)
	{
		if(isEmpty(ch) == true)
		{
			System.out.println("Stack underflow!!");
		}
		else
		{
			if (ch % 2 == 0) 
			{
				item = info[top2];
				top2++;
				System.out.println("Element "+item+" poped from stack 2");
			}
			else
			{
				item = info[top1];
				top1--;
				System.out.println("Element "+item+" poped from stack 1");	
			}
		}
	}

	public void peep(int ch)
	{
		int k;
		if(isFull(ch) == true)
		{
			System.out.println("Stack is empty");
		}
		else
		{
			k =top2;
			if(ch % 2 == 0)
			{
				while(k < info.length)
				{
					System.out.println(info[k]);
					k++;
				}
			}
			else
			{
				k = top1;
				while(k > -1)
				{
					System.out.println(info[k]);
					k--;	
				}
			}
		}
	}

	public boolean isFull(int ch)
	{
		if(ch % 2 == 0)
		{
			if(top2 == top1+1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(top1 == top2-1)
			{
				return true;
			}
			else 
			{
				return false;	
			}
		}
	}

	public boolean isEmpty(int ch)
	{
		if(ch % 2 == 0)
		{
			if(top2 == info.length)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(top1 == -1)
			{
				return true;
			}
			else 
			{
				return false;	
			}
		}
	}
}

class TwoStacks{

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StackOperations s = new StackOperations(10);
		int ch;

		try
		{
			outer: while(true)
			{
				System.out.println("1. Push to stack 1");
				System.out.println("2. Push to stack 2");
				System.out.println("3. Pop from stack 1");
				System.out.println("4. Pop from stack 2");
				System.out.println("5. Display stack 1");
				System.out.println("6. Display stack 2");
				System.out.println("7. Exit");

				ch = Integer.parseInt(br.readLine());
				switch(ch)
				{
					case 1:  s.push(ch);
							 break;
					case 2: s.push(ch); 
					   		break;
					case 3: s.pop(ch);
							break;
					case 4: s.pop(ch);
							break; 
					case 5: s.peep(ch);
							break;
					case 6: s.peep(ch);
							break;
					case 7: System.out.println("Thanks for using Darshan's stack program..!!");
							break outer;
					default:System.out.println("Wrong choice!");
				}

			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
