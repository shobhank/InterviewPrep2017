/**
*@author
*shsharma
*/
package org.shobhank.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrix {

    public static void main(String[] args) {
        int adj[][] = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,1},{0,1,0,0,1},{0,0,0,0,0}};
        Graph g = new Graph(adj);
        g.dfs();
        System.out.println();
        g.bfs();
    }

}

class Graph
{
  /* ------------------------------------------
     Data structure used to represent a graph
     ------------------------------------------ */
  int[][]  adjMatrix;
  int      rootNode = 0;
  int      NNodes;

  boolean[] visited; 

  /* -------------------------------
     Construct a graph of N nodes
     ------------------------------- */
  Graph(int N)
  {
     NNodes = N;
     adjMatrix = new int[N][N];
     visited = new boolean[N];
  }

  Graph(int[][] mat)
  {
     int i, j;

     NNodes = mat.length;

     adjMatrix = new int[NNodes][NNodes];
     visited = new boolean[NNodes];


     for ( i=0; i < NNodes; i++)
        for ( j=0; j < NNodes; j++)
           adjMatrix[i][j] = mat[i][j];
  }

  public void dfs()
  {
     //DFS uses Stack data structure

     Stack<Integer> s = new Stack<Integer>();

     s.push(rootNode);
     visited[rootNode] = true;

     printNode(rootNode);

     while( !s.isEmpty() )
     {
        int n, child;

        n = (s.peek()).intValue();

        child = getUnvisitedChildNode(n);

        if ( child != -1 )
        {
           visited[child] = true;

           printNode(child);

           s.push(child);
        }
        else
        {
           s.pop();
        }
     }

     clearVisited();      //Clear visited property of nodes
  }

  public void bfs(){
      Queue<Integer> queue = new LinkedList<Integer>();
      queue.add(rootNode);
      visited[rootNode] = true;
      while(!queue.isEmpty()){
          int node = queue.poll();
          printNode(node);
          for (int i = 0; i < NNodes; i++)
          {
             if (adjMatrix[node][i]==1 && !visited[i])
             {
                queue.add(new Integer(i));
                visited[i] = true;
             }
          }       
      }
  }

  int getUnvisitedChildNode(int n)
  {
     int j;

     for ( j = 0; j < NNodes; j++ )
     {
    if ( adjMatrix[n][j] > 0 )
        {
       if ( ! visited[j] )
              return(j);
        }
     }

     return(-1);
  }

  void clearVisited()
  {
     int i;

     for (i = 0; i < visited.length; i++)
        visited[i] = false;
  }

  void printNode(int n)
  {
     System.out.print(n+" ");
  }
}

