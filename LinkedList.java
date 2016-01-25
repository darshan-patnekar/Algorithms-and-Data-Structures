//Linked list and its operations 

import java.io.*;
class Node
{
	Object info;
	Node next;
}

class LL
{
	Node start,p,q;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public void createLL() throws Exception
	{
		
		int n;
		if(start!= null)
		{
			System.out.println("List already exists!");	
		}
		else
		{
			System.out.println("Enter the number of elements in the linked list: ");
			n = Integer.parseInt(br.readLine());
			for (int i=1; i<=n; i++)
			{
				System.out.println("Enter the element to be inserted: ");
				Object x = br.readLine();
				q= new Node();
				q.info = x;
				q.next = null;
	
				if(start == null)
				{
					start = q; p=q;
				}
				else
				{
					p.next = q;
					p=q;
				}
			}
		}
	}
    
	public void insertLL()throws Exception
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
				q.next = null;
				q.next = start;
				start = q;
				System.out.println("Element inserted at position "+count);
			}
			else if (choice == 2)
			{
				System.out.println("Enter the element to be inserted: ");
				Object x = br.readLine();
				q= new Node();
				q.info = x;
				q.next = null;
				System.out.println("Enter the element after which the current element is to be inserted: ");
				Object y = br.readLine();
				p = start;

				while(p.next != null && !p.info.equals(y))
				{
					p=p.next;
					count++;
				}
				if(p == null)
				{
					System.out.println("Element not found!");
				}
				else
				{
					q.next = p.next;
					p.next = q;
					System.out.println("Element inserted at position "+ (count+1));
				}
			}

			else if(choice == 3)
			{
				System.out.println("Enter the element to be inserted: ");
				Object x = br.readLine();
				q= new Node();
				q.info = x;
				q.next = null;
				p=start;
				while(p.next != null)
				{
					p=p.next;
					count++;
				}
				p.next = q;
				System.out.println("Element inserted at position "+ (count+1));
			}
			else
			{
				System.out.println("Wrong choice!");
			}
		}
	}

	public void deleteLL() throws Exception
	{
		if(start == null)
		{
			System.out.println("List does not exists!");
		}

		else
		{
			System.out.println("Enter the element to be deleted: ");
			Object x = br.readLine();
			p = start; q = start.next;
			if(p.info.equals(x))
			{
				start = start.next; 
				p.next = null;
				System.out.println("Element "+x+ " has been deleted: ");
			}
			else
			{
				while(q!= null && !q.info.equals(x))
				{
					q = q.next; p= p.next;
				}
				if(q == null)
				{
					System.out.println("Element not found!");
				}
				else
				{
					p.next = q.next;
					q.next = null;
					System.out.println("Element "+x+ " has been deleted: ");
				}
			}

		}
	}
	
	public void searchLL() throws Exception
	{
		if(start == null)
		{
			System.out.println("List does not exists!");
		}
		else
		{
			System.out.println("Eneter the element to be searched: ");
			Object x = br.readLine();
			p= start;
			int count = 1;
			while(p!=null && !p.info.equals(x))
			{
				p=p.next;
				count++;
			}
			if (p == null)
			{
				System.out.println("Element does not exists!");
			}
			else
			{
				System.out.println("Element "+x+ " is present at position "+count);
			}
		}
		
	}
	public void displayLL()
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
				p=p.next;
			}
		}
	}
}

class LinkedList
{
	public static void main(String[] args) throws IOException
	{
		int ch;
		LL l = new LL();	
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
					case 1: l.createLL();
							break;
					case 2:	l.insertLL();
							break;
					case 3: l.deleteLL();
							break;
					case 4: l.displayLL();
							break;
					case 5: l.searchLL();
							break;
					case 6: System.out.println("Thank You for using Darshan's LinkedList. \nHave a wonderful day!");
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