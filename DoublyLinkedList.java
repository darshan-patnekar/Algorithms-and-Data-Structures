//Program to implement Doubly linked list and its operations

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Node
{
	Object info;
	Node left, right;
}

class DLL
{
	Node start, p, q, r;
	Object x;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void createDLL()throws Exception
	{
		if(start!= null)
		{
			System.out.println("List already exists!");
		}
		else
		{
			System.out.println("How many elements do you want in the list? ");
			int n = Integer.parseInt(br.readLine());

			for(int i=1; i <=n; i++)
			{
				System.out.println("Enter the elements: ");
				x= br.readLine();
				q= new Node();
				q.info = x;
				q.left =null;
				q.right= null;
				
				if(start == null)
				{
					start = q;
					p=q;
				}
				else
				{
					p.right = q;
					q.left = p;
					p = q;
				}

			}	
		}
	}
	public void displayDLL()

	{
		if(start == null)
		{
			System.out.println("List does not exists!");
		}
		else
		{
			p= start;
			while(p!=null)
			{
				System.out.println(p.info);
				p=p.right;
			}
		}
	}
	public void insertDLL() throws Exception
	{
		if(start == null)
		{
			System.out.println("List is not yet created please create a list first! ");
		}
		else
		{
			System.out.println("Select the position where the new element is to be inserted:");
			System.out.println("Enter \n1. Beginning \n 2. Between \n 3. End");
			int choice = Integer.parseInt(br.readLine());
			
			
			int count=1;
			if(choice == 1 )
			{	
				System.out.println("Enter the element to be inserted: ");
				Object x = br.readLine();
				q= new Node();
				q.info = x;
				q.right = start;
				start.left = q;
				start = q;
				System.out.println("Element inserted at position "+count);
			}
			else if (choice == 2)
			{
				System.out.println("Enter the element to be inserted: ");
				Object x = br.readLine();
				q= new Node();
				q.info = x;
				q.left = null;
				q.right = null;
				System.out.println("Enter the element after which the current element is to be inserted: ");
				Object y = br.readLine();
				p = start;

				while(p.right!= null && !p.info.equals(y))
				{
					p=p.right;
					count++;
				}
				if(p == null)
				{
					System.out.println("Element not found!");
				}
				else
				{
					r = p.right;
					p.right = q;
					q.left = p;
					q.right = r;
					r.left = q;
							
					System.out.println("Element inserted at position "+ (count+1));
				}
			}

			else if(choice == 3)
			{
				System.out.println("Enter the element to be inserted: ");
				Object x = br.readLine();
				q= new Node();
				q.info = x;
				q.left = null;
				q.right = null;
				p=start;
				while(p.right!= null)
				{
					p=p.right;
					count++;
				}
				p.right = q;
				q.left = p;
				System.out.println("Element inserted at position "+ (count+1));
			}
			else
			{
				System.out.println("Wrong choice!");
			}
		}
	}
	public void deleteDLL() throws Exception
	{
		if(start == null)
		{
			System.out.println("List does not exists!");
		}
		else
		{
			System.out.println("Enter the element to be deleted: ");
			Object x = br.readLine();
			p = start; q= start.right; 
			if(p.info.equals(x))
			{
				start = start.right;
				if (start!=null)
				{
					start.left = null;
				}
				p.right = null;
				System.out.println("Start Element "+x+ " has been deleted: ");
			}
			else
			{
				while (q!=null && !q.info.equals(x))
				{
					q = q.right; p = p.right; 
				}
				if (q == null)
				{
					System.out.println("Element not found!");
				}
				else
				{
					
					r= q.right;
					p.right = q.right;
					if(r!= null)
					{
						r.left = p;
					}
					q.left =null;
					q.right= null;
					System.out.println("Element "+x+ " has been deleted: ");
				}
				
			}
		}
	}
	public void searchDLL() throws Exception
	{
		if(start == null)
		{
			System.out.println("List does not exists!");
		}
		else
		{
			System.out.println("Enter the element to be searched: ");
			Object x = br.readLine();
			int count = 1;
			p= start;
			while(p!=null && !p.info.equals(x))
			{
				p=p.right;
				count++;
			}
			if(p == null)
			{
				System.out.println("Element not found!");
			}
			else
			{
				System.out.println("Element "+x+" present at position "+count);
			}
		}
	}
}

class DoublyLinkedList
{
	public static void main(String[] args) throws IOException
	{
		int ch;
		DLL dl = new DLL();	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		outer: while(true)
		{
			System.out.println("1. Create");
			System.out.println("2. Insert");
			System.out.println("3. Delete");
			System.out.println("4. Display");
			System.out.println("5. Search");
			System.out.println("6. Exit");
			try
			{
				ch = Integer.parseInt(br.readLine());	
				switch(ch)
				{
					case 1: dl.createDLL();
							break;
					case 2:	dl.insertDLL();
							break;
					case 3: dl.deleteDLL();
						 	break;
					case 4: dl.displayDLL();
							break;
					case 5: dl.searchDLL();
							break;
					case 6: System.out.println("Thank You for using Darshan's Doubly Linked List. \nHave a wonderful day!");
						    break outer;
					default: System.out.println("Enter a valid choice!");
				}
			}

			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}