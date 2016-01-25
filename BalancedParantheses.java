package parentheses;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParantheses 
{
	HashMap<Character, Character> brackets = new HashMap<Character, Character>();
	{
		brackets.put('{','}');
		brackets.put('[',']');
		brackets.put('(',')');
	}
	
	public boolean isBalanced(String s)
	{
		Stack<Character> stk = new Stack<Character>();
		s = s.replaceAll( ":\\(", "" );
        s = s.replaceAll( ":\\)", "" );
        s = s.replaceAll( ":\\-\\)", "" );
		for(int i =0; i <s.length(); i++)
		{
			if(brackets.containsKey(s.charAt(i)))
			{	
				stk.push(s.charAt(i));
			}
			else
			{
				if(brackets.containsValue(s.charAt(i)) && s.charAt(i)!= brackets.get(stk.pop()))
				{
					return false;
				}
			}
		}
		
		if(!stk.empty()) return false;
		else return true;
	}
	
	public static void main(String[] args) {
		BalancedParantheses b = new BalancedParantheses();
		if(b.isBalanced("{{{:-)}}}")) System.out.println ("Balanced 1");
		if(b.isBalanced("{{()}}")) System.out.println ("Balanced 2");
		if(b.isBalanced("{{{Darshan}}}")) System.out.println ("Balanced 3");
		if(!b.isBalanced("{{{}}")) System.out.println ("UnBalanced 4");
		if(b.isBalanced("")) System.out.println ("Balanced 5");
		
	}	
}
