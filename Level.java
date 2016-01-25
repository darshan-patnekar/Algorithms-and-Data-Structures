package levelTranversal;


import java.util.ArrayList; 
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;


class BinaryTreeNode
{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class Level 
{
	public ArrayList<Integer> levelTraversal(BinaryTreeNode root)
	{
		ArrayList<Integer> curr = new ArrayList<Integer>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode tmp = q.poll();
			if(tmp!=null)
			{
				curr.add(tmp.data);
				if(tmp.left!=null)
				{
					q.add(tmp.left);
				}
				if(tmp.right!=null)
				{
					q.add(tmp.right);
				}
			}
		}
		
		return curr;
	}
	public int maxBinary(BinaryTreeNode root)
	{
		int maxValue = Integer.MIN_VALUE;
		if(root!=null)
		{
			int leftMaxValue = maxBinary(root.left);
			int rightMaxValue = maxBinary(root.right);
			
			if(leftMaxValue > rightMaxValue)
			{
				maxValue =  leftMaxValue;
			}
			else
			{
				maxValue =  rightMaxValue;
			}
			if(root.data > maxValue)
			{
				maxValue = root.data;
			}
		}
		return maxValue;

	}
	
	public void reverseTree(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> s= new Stack<BinaryTreeNode>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		if(root!= null)
		{
			q.add(root);
		}
		while(!q.isEmpty())
		{
			BinaryTreeNode tmp = q.poll();
			if(tmp!=null)
			{
				if(tmp.right!=null)
				{
					q.add(tmp.right);
				}
			}
			if(tmp.left!=null)
			{
				q.add(tmp.left);
			}
			s.push(tmp);
		}
		while(!s.isEmpty())
		{
			System.out.println(s.pop().data);
		}
	}	
		
		public void printPaths(BinaryTreeNode root)
		{
			int[] paths = new int[256];
			printPaths(root, paths, 0);
		}
	
		private void printPaths(BinaryTreeNode root, int [] path, int pathLength)
		{
			
			if(root == null)
			{
				return;
			}
			else
			{
				path[pathLength] = root.data;
				pathLength++;
				
				if(root.left == null && root.right==null)
				{
					printPath(path, pathLength);
				}
				else
				{
					printPaths(root.left, path, pathLength);
					printPaths(root.right, path, pathLength);
				}
			}
			
		}
		
		private void printPath(int[] path, int pathLen)
		{
			for(int i =0; i < pathLen;i++)
			{
				System.out.print(path[i]+ " ");
			}
			System.out.println();
		}
	
		
		public void printPaths1(BinaryTreeNode root)
		{
			ArrayList<Integer> paths = new ArrayList<Integer>();
			printPaths1(root, paths, 0);
		}
	
		private void printPaths1(BinaryTreeNode root, ArrayList<Integer> path, int pathLength)
		{
			
			if(root == null)
			{
				return;
			}
			
			
			path.add(pathLength, root.data);
			pathLength++;
			
			if(root.left == null && root.right==null)
			{
				printPath1(path, pathLength);
			}
			else
			{
				printPaths1(root.left, path, pathLength);
				printPaths1(root.right, path, pathLength);
			}
			
			
		}
		
		private void printPath1(ArrayList<Integer> path, int pathLen)
		{
			//for(int i =0; i < pathLen;i++)
			{
				System.out.println(path);
			}
			//System.out.println();
		}
		
		
	public static void main(String[] args) 
	{
		Level l = new Level();
		BinaryTreeNode bt7 = new BinaryTreeNode(7,null,null);
		BinaryTreeNode bt6 = new BinaryTreeNode(6,null,null);
		BinaryTreeNode bt5 = new BinaryTreeNode(5,null,null);
		BinaryTreeNode bt4 = new BinaryTreeNode(4,null,null);
		BinaryTreeNode bt3 = new BinaryTreeNode(3,bt6,bt7);
		BinaryTreeNode bt2 = new BinaryTreeNode(2,bt4, bt5);
		BinaryTreeNode bt1 = new BinaryTreeNode(1,bt2,bt3);
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		//res = l.levelTraversal(bt1);
		//System.out.println(res);
		//l.reverseTree(bt1);
		l.printPaths(bt1);
		l.printPaths1(bt1);
		
	}
}
