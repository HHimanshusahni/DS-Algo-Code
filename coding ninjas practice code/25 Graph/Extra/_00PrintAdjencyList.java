
import java.util.*;
import java.lang.*;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/print-adjacency-list/0
class Graph{
    public void addEdge(ArrayList<ArrayList<Integer>> adjList,int vertex1 ,int vertex2){
        ArrayList<Integer> list = adjList.get(vertex1);
        list.add(vertex2);
        
        list = adjList.get(vertex2);
        list.add(vertex1);
    }
    public void printGraph(ArrayList<ArrayList<Integer>>adjList){
        for(int j = 0 ;j < adjList.size();j++){
            ArrayList<Integer>list = adjList.get(j);
            System.out.print(j);
            for(int i = 0 ;i < list.size();i++){
                System.out.print("-> "+list.get(i));
            
            }
            System.out.println();
        }
    }
}
class  _00PrintAdjencyList{
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for(int t = 0 ;t < test;t++){
		    int V = s.nextInt();
		    int E = s.nextInt();
		    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		    for(int i = 0;i  < V;i++)
		        adjList.add(new ArrayList<Integer>());
		    Graph graph = new Graph();
		    for(int i = 0;i < E;i++){
		        graph.addEdge(adjList,s.nextInt(),s.nextInt());
		    }
		    graph.printGraph(adjList);
		}
	}
}