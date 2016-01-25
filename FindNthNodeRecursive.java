package p1; 
class Node
{
	private int data;
	private Node next;

	public void setData(int data)
	{
		this.data = data;
	}
	
	public int getData()
	{
		return data;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public Node getNext()
	{
		return next;
	}
}

class FindNthNodeRecursive
{
	Node start,p,q;
	int counter = 0;
	public Node createList()
	{	
		for(int i=1; i<=10; i++)
		{
			q = new Node();
			q.setNext(null);

			if(start == null)
			{
				start = p = q;
				q.setData(i);	
			}
			else
			{
				q.setData(i);
				p.setNext(q);
				p = q;	
			}
		}
		return start;
	}
	public void listNode(Node head, int nthNode)
	{
		if(head!=null)
		{
			listNode(head.getNext() , nthNode);
			counter++;
			if(counter == nthNode)
			{
				System.out.println("The nth node for the given data is "+head.getData());
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
			p = start;
			while(p!=null)
			{
				System.out.println(p.getData());
				p=p.getNext();
			}
		}
	}
	public static void main(String[] args) 
	{
		Node start;
		FindNthNodeRecursive fn = new FindNthNodeRecursive();
		start = fn.createList();
		fn.listNode(start, 7);
		//fn.displayLL();	
	}
}