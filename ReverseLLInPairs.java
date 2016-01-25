//Reversing a linked list

package p3; 
class Node
{
	private int data;
	Node next;

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

class ReverseLLInPairs
{
	Node start, p, q, temp,temp1;
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
		if(head==null || head.getNext()==null)
		{
			return null;
		}
		else
		{
			temp = head.getNext();
			head.setNext(temp.getNext());
			temp.setNext(head);
			head = temp;
			
			
			head.next.next = reverseLL(head.next.next); 
			return head;
		}
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
				System.out.print(p.getData()+" ");
				p=p.getNext();
			}
		}
	}
	public static void main(String[] args) 
	{
		Node start, prev;
		ReverseLLInPairs fn = new ReverseLLInPairs();
		start = fn.createList();
		fn.displayLL(start);	
		prev = fn.reverseLL(start);
		System.out.println();
		fn.displayLL(prev);
	}
}