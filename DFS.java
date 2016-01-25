package dfs;

import java.io.*;
import java.util.*;

class Vertex
{
	public char label;
	public boolean visited;

	public Vertex(char lab)
	{
		label = lab;
		visited = false;
	}
}

class Graph
{
	private final int maxCount = 20;
	private int adjMatrix [][];
	private Vertex vertex[];
	private int count;
	private Stack dfsStack;

	public Graph()
	{
		adjMatrix = new int[maxCount][maxCount];
		vertex = new Vertex[maxCount];
		dfsStack = new Stack();
		for(int i = 0; i<maxCount; i++)
		{
			for( int j = 0; j< maxCount; j++)
			{
				adjMatrix[i][j] = 0;
			}
		}
		count = 0;
	}

	public void addNewVertex(char lab)
	{
		vertex[count++] = new Vertex(lab);
	}

	public void setEdge(int start, int end)
	{
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	public void displayVertex(int v)
	{
		System.out.println(vertex[v].label);
	}

	public int findUnvisitedVertex(Object v)
	{
		int x = (int)v;
		for(int j=0; j<count; j++)
		{
			if(adjMatrix[x][j]==1 && vertex[j].visited==false)
			{
				return j;
			}
		}
		return -1;
	}

	public void dfs() throws Exception
	{
		if(vertex[0] != null)
		{
			vertex[0].visited =  true;
			displayVertex(0);
			dfsStack.push(0);

			while(!dfsStack.isEmpty())
			{
				int v = findUnvisitedVertex(dfsStack.peek());

				if(v==-1)
				{
					dfsStack.pop();
				}
				else
				{
					vertex[v].visited = true;
					displayVertex(v);
					dfsStack.push(v);
				}
			}
		}
		else
		{
			throw new Exception("Please add a vertex to the graph");
		}
	}
}

public class DFS
{
	public static void main(String[] args) throws Exception
	{
		Graph g = new Graph();
		g.addNewVertex('A');
		g.addNewVertex('B');
		g.addNewVertex('C');
		g.addNewVertex('D');
		g.addNewVertex('F');
		g.addNewVertex('E');
		g.addNewVertex('G');
		g.addNewVertex('H');

		g.setEdge(0,1);
		g.setEdge(1,0);
		g.setEdge(1,2);
		g.setEdge(1,7);
		g.setEdge(2,1);
		g.setEdge(2,3);
		g.setEdge(2,4);
		g.setEdge(3,2);
		g.setEdge(4,2);
		g.setEdge(4,5);
		g.setEdge(4,6);
		g.setEdge(4,7);
		g.setEdge(5,4);
		g.setEdge(6,4);
		g.setEdge(7,1);
		g.setEdge(7,4);

		g.dfs();

	}
}