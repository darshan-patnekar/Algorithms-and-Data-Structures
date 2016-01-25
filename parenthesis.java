package string;


import java.io.*;
import java.util.*;


public class parenthesis
{
	static boolean flag = true;
	static Stack<Character> stack = new Stack<Character>();
	
	public static boolean par(String s)
	{
		HashMap<Character, Character> h = new HashMap<Character, Character>();
		h.put('{','}');
		h.put('(',')');
		
		for(int i = 0; i<s.length();i++)
		{
			if(s.charAt(i)=='{'||s.charAt(i)=='(' )
			{
				stack.push(s.charAt(i));
			}
			
			if(s.charAt(i)=='}'||s.charAt(i)==')' )
			{
				if(!stack.isEmpty())
				{
					char c = stack.peek();
					if(!(stack.pop() == h.get(c))) 
					{
						flag = false;
					}
				}
			}
		}
		
		if(stack.isEmpty())
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		return flag;
	}
	
	public static void main(String[] args)
	{
		String s = "((){})";
		if(par(s))
		{
			System.out.println("The parenthesis are balanced");
		}
		else
		{
			System.out.println("The parenthesis are not balanced");
		}
	
	}
	
}