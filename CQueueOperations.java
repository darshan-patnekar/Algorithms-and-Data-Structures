//Program to implement Circular queue and its operations
import java.io.*;

class CircularQueue
{	
	private int front, rear;
	private Object [] cqueue;

	public CircularQueue(int capacity)
	{								 
		cqueue = new Object[capacity];
		front = rear = -1;
	}

	public void cqueueInsert(Object item)
	{
		if(rear == cqueue.length-1)
		{
			rear = 0;
		}
		else
			rear++;

		if(rear == front)
		{
			if(rear == 0)
			{
				rear = cqueue.length-1;
			}
			else 
			{
				rear--;
			}
			System.out.println("Queue overflow!");
		}
		else
		{
			cqueue[rear] = item;
			if (front == -1) 
			{
				front = 0;
			}	
		}
	}

	public Object cqueueDelete() throws Exception
	{
		if(front == -1)
		{
			throw new Exception ("Queue is empty!");
		}
		else 
		{
			Object item = cqueue[front];
			cqueue[front] = null;
			
			if (front == rear) 
			{
				front = rear = -1;		
			}
			else if (front == cqueue.length-1) 
			{
				front = 0;		
			}
			else 
			{
				front++;		
			}
			return item;	
		}
	}

	public void cqueueDisplay()
	{
		if(front == -1)
		{
			System.out.println("Queue is empty!");
		}
		else 
		{
			for (int i = 0; i<= cqueue.length-1; i++)
			{
				System.out.println(cqueue[i]);
			}	
		}
	}
}

class CQueueOperations
{
	public static void main(String[] args) 
	{
		int ch;
		Object e1;
		CircularQueue cq = new CircularQueue(5);	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		outer: while(true)
		{
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			try
			{
				ch = Integer.parseInt(br.readLine());	
				switch(ch)
				{
					case 1: System.out.println("Enter the item to be inserted: ");
							e1= br.readLine();
							cq.cqueueInsert(e1);
							break;
					case 2:	e1= cq.cqueueDelete();
							System.out.println("Element deleted: "+e1);
							break;
					case 3: cq.cqueueDisplay();
							break;
					case 4: break outer;
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