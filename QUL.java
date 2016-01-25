package queueUsingList;

//Reversing a queue using recursion
import java.io.*;
import java.util.*;


class LinkedList
{
	int data;
	LinkedList next;
	LinkedList prev;
}


public class QUL
{
	public static LinkedList reverseQueue(LinkedList head)
	{
		LinkedList current = head;
		if(current == null)
		{
			return null;
		}
		LinkedList next = current.next;
		
		if(next == null)
		{
			head = current;
			return head;
		}
		
		head = reverseQueue(next);
		next.next = current;
		current.prev = next;
		next.prev = null;
		current.next = null;
		return head;
		
	}
	
	public static void displayQueue(LinkedList head)
	{
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	public static void main(String [] args)
	{
		LinkedList p= null,q=null, head = null;
		
		for(int i =1 ; i<=10; i++)
		{
			q = new LinkedList();
			q.data = i;
			q.next = null;
			
			if(head == null)
			{
				head = q;
				p=q;
			}
			else
			{
				p.next = q;
				p=q;
			}
		}
		displayQueue(head);
		
		head = reverseQueue(head);
		
		displayQueue(head);
		
	}
	
	
}