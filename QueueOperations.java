//Queue operations 

import java.io.*;

class Queue
{
	private int front, rear;
	private Object [] queue;

	public Queue(int capacity)
	{								 
		queue = new Object[capacity];
		front = rear = -1;
	}

	public boolean isFull()
	{
		return rear == queue.length-1;
	}

	public boolean isEmpty()
	{
		return front == -1;
	}

	public Object queueFront() throws Exception
	{
		if (isEmpty()) 
		{
			throw new Exception("Queue has no items!");	
		}
		else 
		{
			return queue[front];	
		}
	}

    public int queueSize() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Queue overflow");
		}
		else
		{
			int count=0;
			for(int i=front; i<=rear;i++)
			{
				count++;
			}
			return count;
		}
		
	}
	public void displayQueue()
	{
		if(isEmpty())
		{
			System.out.println("Queue overflow");
		}
		else
		{
			for(int i=front; i<=rear;i++)
			{
				System.out.println(queue[i]);
			}
		}
		
	}

	public void insertQueue(Object item)
	{
		if(isFull())
		{
			System.out.println("Queue overflow");
		}
		else
		{
			rear++;
			queue[rear] = item;
			if(front  == -1)
			{
				front = 0;			//First insertion
			}
			
		}
	}

	public Object deleteQueue()throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Queue is empty. Deletion not possible!");
		}
		else
		{
			Object item = queue[front];
			queue[front] = null;
			if (front == rear) 
			{
				front = rear = -1;
			}
			else
			{
				front++;

			}
			return item;
		}		
	}
}

class QueueOperations
{
	public static void main(String[] args) 
	{
		int ch;
		Object e1;
		Queue q = new Queue(5);	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		outer: while(true)
		{
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Display");
			System.out.println("4. Size of queue");
			System.out.println("5. Front");
			System.out.println("6. Exit");
			try
			{
				ch = Integer.parseInt(br.readLine());	
				switch(ch)
				{
					case 1: System.out.println("Enter the item to be inserted: ");
							e1= br.readLine();
							q.insertQueue(e1);
							break;
					case 2:	e1= q.deleteQueue();
							System.out.println("Element deleted: "+e1);
							break;
					case 3: q.displayQueue();
							break;
					case 4: System.out.println("Queue size: "+q.queueSize());
							break;
					case 5: System.out.println("Front: "+q.queueFront());
							break;
					case 6: break outer;
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