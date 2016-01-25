package bfs;

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
	public final int maxCount  = 20;
	private int [][] adjMatrix;
	private Vertex [] vertexList;
	private int countVertex;
	private Queue<Integer> q;

	public Graph()
	{
		adjMatrix = new int [maxCount][maxCount];
		vertexList = new Vertex[maxCount];
		for(int i =0;i<maxCount; i++)
		{
			for(int j =0; j<maxCount; j++)
			{
				adjMatrix[i][j] = 0;
			}	
		}

		q = new LinkedList<Integer>();
		countVertex = 0; 
	} 

	public void addNewVertex(char lab)
	{
		vertexList[countVertex++] = new Vertex(lab);
	}

	public void setEdge(int start, int end)
	{
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	public void displayVertex(int vertex)
	{
		System.out.print(vertexList[vertex].label);
	}


	public int findUnvisitedVertex(int vertex)
	{
		for(int j=0; j<countVertex; j++)
		{
			if(adjMatrix[vertex][j] == 1 && vertexList[j].visited == false )
			{
				return j;
			}
		}
		return -1;
	}

	public void bfs() throws Exception
	{
		int v1, v2;
		if(vertexList[0] != null)
		{
			vertexList[0].visited = true;
			displayVertex(0);
			q.add(0);
			
			while(!q.isEmpty())
			{
				v1 = q.remove();

				while((v2 = findUnvisitedVertex(v1))!= -1)
				{
					vertexList[v2].visited = true;
					displayVertex(v2);
					q.add(v2);			
				}
			}	
		}
		else
		{
			throw new Exception("Graph is empty!");
		}
	}
}

public class BFS 
{
	public static void main(String[] args) throws Exception 
	{
		
		Graph g = new Graph();
		g.addNewVertex('A');
		g.addNewVertex('B');
		g.addNewVertex('C');
		g.addNewVertex('D');
		g.addNewVertex('E');
		g.addNewVertex('F');
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

		g.bfs();
	}
}