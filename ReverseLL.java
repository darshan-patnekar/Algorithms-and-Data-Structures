//Reversing a linked list

package p2; 
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

class ReverseLL
{
	Node start, p, q, current, prev, next;
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
	public Node reverseLL(Node head)
	{
		current = head;
		prev  = null;

		while(current!=null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
	}

	public void displayLL(Node start)
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
		Node start, prev;
		ReverseLL fn = new ReverseLL();
		start = fn.createList();
		fn.displayLL(start);	
		prev = fn.reverseLL(start);
		fn.displayLL(prev);
	}
}