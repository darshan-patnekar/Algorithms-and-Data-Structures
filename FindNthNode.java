//Finding the Nth node in a linked list

class Node
{
	int data;
	Node next;
}

class FindNthNode
{
	Node start,p,q;
	public Node createList()
	{	
		for(int i=1; i<=10; i++)
		{
			q = new Node();
			q.next = null;

			if(start == null)
			{
				start = p = q;
				q.data = i;	
			}
			else
			{
				q.data = i;
				p.next = q;
				p = q;	
			}
		}
		return start;
	}
	public void listNode(Node node, int nthNode)
	{
		if(start!=null)
		{
			p = q = start;
		}
		for(int i = 1; i<=7; i++)
		{
			if(q.next!=null)
			{
				q = q.next;
			}
		}
		while(q!=null)
		{
			p = p.next;
			q = q.next;
		}
		System.out.println("The nth node for the given data from the end is "+p.data);
	}

	public void displayLL()
	{
		if(start == null)
		{
			System.out.println("List does not exists!");
		}
		else
		{
			p = start;
			while(p!=null)
			{
				System.out.println(p.data);
				p=p.next;
			}
		}
	}
	public static void main(String[] args) 
	{
		Node start;
		FindNthNode fn = new FindNthNode();
		start = fn.createList();
		fn.listNode(start, 7);
		//fn.displayLL();	
	}
}