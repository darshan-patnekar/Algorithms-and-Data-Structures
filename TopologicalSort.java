package graphs;

//Program to implement Topological Sort in graphs

import java.io.*;
import java.util.*;

class GraphNode
{
	int label;
	GraphNode next;
	
	public GraphNode(int lab)
	{
		label = lab;
		next = null;
	}
}

class Graph
{
	ArrayList<GraphNode> graph;
	
	public Graph()
	{
		graph = new ArrayList<GraphNode>(7);
	}

	public void addVertex(int i) 
	{
		GraphNode n = new GraphNode(i);
		graph.add(i,n);
	}
	
	public void addEdge(int start, int end)
	{
		GraphNode temp = new GraphNode(end);
		temp.next = graph.get(start).next;
		graph.get(start).next = temp; 
	}
	
	public void printGraph(Graph g)
	{
		for(int i= 0; i<7; i++)
		{
			GraphNode temp = graph.get(i);
			
			while(temp!=null)
			{
				temp = temp.next;
				if(temp!=null)
				System.out.println(i + " -> " + temp.label);
				
			}
		}
	}
	
	public GraphNode getNode(int id)
	{
		for(int i = 0; i < graph.size(); i++)
		{
			if (id == graph.get(i).label)
			{
				return graph.get(i);
			}	
		}
		return null;
	}
}

public class TopologicalSort
{	
	public static void sort(Graph g, int noOfVertices)
	{
		Hashtable<Integer, Integer> inDegree = new Hashtable<>();
		ArrayList<GraphNode> zeroInDegree = new ArrayList<GraphNode>();
		ArrayList<GraphNode> node = g.graph;
		
		
		for (int i = 0 ; i<7; i++)
		{
			GraphNode temp = node.get(i);
			
			temp = temp.next;
			while(temp!=null)
			{
				int count = (inDegree.get(temp.label)==null)?0: (int) inDegree.get(temp.label);
				inDegree.put(temp.label,(count+1));
				temp = temp.next;
			}		
		}
		
		for (int i = 0 ; i<7; i++)
		{
			GraphNode temp = node.get(i);
			
			if(inDegree.get(temp.label)==null)
			{
				zeroInDegree.add(temp);
			}
			
		}
		
		while(!zeroInDegree.isEmpty())
		{
			GraphNode curr = zeroInDegree.remove(0);
			System.out.print(curr.label + " ");
			
			GraphNode temp = curr.next;
			
			while(temp!=null)
			{
				int prevInDegree = (int) inDegree.get(temp.label);
				inDegree.put(temp.label, prevInDegree-1);
				if(prevInDegree ==1)
				{
					zeroInDegree.add(g.getNode(temp.label));					
				}
				temp = temp.next;
			}			
		}
		
	}
	
	public static void main (String[] args)
	{
		Graph g = new Graph();
		for(int i = 0; i<7;i++)
		{
			g.addVertex(i);
		}
		
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(1,4);
		g.addEdge(1,6);
		g.addEdge(2,5);
		g.addEdge(3,0);
		g.addEdge(3,5);
		g.addEdge(4,5);
		g.addEdge(6,4);
		
		g.printGraph(g);
		sort(g, 7);
	}
}