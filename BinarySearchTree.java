//Program to implement Binary search tree

import java.io.*;
class Node
{
	int info;
	Node left, right;
}

class BSTOperations
{
	Node root,p,q,r,s;
	int x; 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void inorder(Node p)
	{
		if(p!=null)
		{
			inorder(p.left);
			System.out.println(p.info);
			inorder(p.right);
		}
	}

	public void search() throws Exception
	{
		p = root;
		if(p == null)
		{
			System.out.println("Tree is empty!");
		} 
		else
		{
			System.out.println("Enter the element to be searched: ");
			x = Integer.parseInt(br.readLine());
	
			
			while(p != null && p.info!= x)
			{
				if(x < p.info)
				{
					p = p.left;
				}
				else
				{
					p = p.right;
				}
			}
			if(p == null)
			{
				System.out.println("Element not found");
			} 
			else
			{
				System.out.println("Element found");
			}
		}
	}

	public void insert() throws Exception
	{
		System.out.println("How many elements? ");
		int n = Integer.parseInt(br.readLine());
		
		System.out.println("Enter the elements to be inserted: ");
		for (int i = 1; i<= n; i++)
		{
			x = Integer.parseInt(br.readLine());
			
			r = new Node();
			r.info = x;
			r.left = r.right = null;
			
			if(root == null)
			{
				root = r;
				System.out.println("Element inserted!");
			}
			
			else
			{
				q = null;
				p  = root;
				while(p!=null && p.info!= x)
				{
					q = p;
					if(x < p.info)
					{
						p = p.left;
					}
					else
					{
						p = p.right;
					} 	
				}
				if(p == null)
				{
					if(x < q.info)
					{
						q.left = r;
					}
					else
					{
						q.right = r;
					}
					System.out.println("Element inserted!");
				}
				else
				{
					System.out.println("Duplicate insertion!");	
				}
			}
		}
	}

	public void delete() throws Exception
	{
		p = root;
		if(p == null)
		{
			System.out.println("Tree is empty!");
		} 
		

		else
		{
			System.out.println("Enter the element to be deleted: ");
			x= Integer.parseInt(br.readLine());
		
			q = null;
			while(p!= null && p.info!=x)
			{
				q=p;
				if(x < p.info)
				{
					p = p.left;
				}
				else
				{
					p = p.right;
				}
			}
			
			if(p == null)
			{
				System.out.println("Element not found");
			}
			
			else if(p.left == null && p.right == null)
			{
				if(p == root)
				{
					root =null;
				}
				else
				{
					if(p == q.left)
					{
						q.left = null;
					}
					else
					{
						q.right = null;
					}
				}
				System.out.println("Element deleted!");
			}
	
			else if(p.right == null)
			{
				if(q!=null)
				{
					if(p == q.left)
					{
						q.left = p.left;
					}
					else
					{
						q.right = p.left;
					}
				}
				else
				{
					root = p.left;
				}
				System.out.println("Element deleted!");
			}
	
			else if(p.left == null)
			{
				if(q!= null)
				{
					if(p == q.left)
					{
						q.left = p.right;
					}
					else
					{
						q.right = p.right;
					}
				}
				else
				{
					root = p.right;
				}
				System.out.println("Element deleted!");
			}
	
			else
			{
				r=s=p.right;
				
				while(s.left != null)
				{
					s=s.left;
				}
				if(q == null)
				{
					root =r;
				}
				else
				{
					if(p == q.left)
					{
						q.left = r;
					}
					else
					{
						q.right = r; 
					}
				}
				s.left  = p.left;
				System.out.println("Element deleted!");
			}
			
		}
	}
}

class BinarySearchTree
{
	public static void main(String[] args)
	{
		int ch;
		BSTOperations b = new BSTOperations();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		outer: while(true)
		{
			System.out.println("1. Insert");
			System.out.println("2. Display");
			System.out.println("3. Search");
			System.out.println("4. Delete");
			System.out.println("5. Exit");

			try
			{
				ch = Integer.parseInt(br.readLine());

				switch(ch)
				{
					case 1: b.insert();
							break;
					case 2: if(b.root == null)
							{
								System.out.println("Tree is empty!");
							}
							else
							{
								b.inorder(b.root);	
							}
							break;
					case 3: b.search();
							break;
					case 4: b.delete();
							break;
					case 5:break outer;
					default: System.out.println("Wrong Choice!");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}	
}