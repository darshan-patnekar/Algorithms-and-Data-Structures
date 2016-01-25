package Traversal;

import java.util.ArrayList;
import java.util.Stack;

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

public class PostOrder 
{
	

	public ArrayList<Integer> postOrder(BinaryTreeNode root)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		BinaryTreeNode prev = null;
		
		while(!s.isEmpty())
		{
			BinaryTreeNode cn = s.peek();
			if(prev == null || prev.left == cn || prev.right == cn)
			{
				if(cn.left!= null)
				{
					s.push(cn.left);
				}
				else if(cn.right!=null)
				{
					s.push(cn.right);
				}
			}
			else if(cn.left==prev)
			{
				if(cn.right != null)
				{
					s.push(cn.right);
				}	
			}
			else
			{
				res.add(cn.data);
				s.pop();
			}
			prev = cn;
		}
		return res;
	}
	/*public ArrayList<Integer> postOrder(BinaryTreeNode root)
	{		
		if (root != null)
		{
			postOrder(root.left);
			postOrder(root.right);
			res.add(root.data);
		}
		return res;
		
	}*/
	
	public static void main(String[] args) 
	{
		
		BinaryTreeNode bt5 = new BinaryTreeNode(5,null,null);
		BinaryTreeNode bt4 = new BinaryTreeNode(4,null,null);
		BinaryTreeNode bt3 = new BinaryTreeNode(3,null,null);
		BinaryTreeNode bt2 = new BinaryTreeNode(2,bt4, bt5);
		BinaryTreeNode bt1 = new BinaryTreeNode(1,bt2,bt3);
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		PostOrder p = new PostOrder();
		res = p.postOrder(bt1);
		System.out.println(res);
		
	
	}
}
