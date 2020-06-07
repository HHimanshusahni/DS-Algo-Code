import java.util.*;
public class _03GetPathDFS{
	public static ArrayList<Integer> getPathDFS(int[][] adjMatrix,int startVertex,int endVertex){
		boolean visited[] = new boolean[adjMatrix.length];
		ArrayList<Integer> ans = getPathDFS(adjMatrix,startVertex,endVertex,visited);
		if(ans != null)
			ans.add(startVertex);
		return ans;
	}
	public static ArrayList<Integer> getPathDFS(int[][] adjMatrix,int startVertex,int endVertex,boolean visited[]){
		visited[startVertex]  = true;
		if(startVertex == endVertex){
			ArrayList<Integer>path = new ArrayList<Integer>();
			return path;
		}
		for(int vertex = 0;vertex < adjMatrix.length;vertex++){
			if(!visited[vertex] && adjMatrix[startVertex][vertex] == 1){
				ArrayList<Integer> path = getPathDFS(adjMatrix,vertex,endVertex,visited);
				if(path != null){
					path.add(vertex);
					return path;
				}
			}
		}
		return null;
	}	
	public static void main(String []args){
		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		int adjMatrix[][] = new int[V][V];
		for(int e = 0;e  < E;e++){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;
		}
		int startVertex = scanner.nextInt();
		int endVertex = scanner.nextInt();
		ArrayList<Integer> path = getPathDFS(adjMatrix,startVertex,endVertex);
		if(path != null)
			for(int p = 0;p < path.size();p++)
				System.out.print(path.get(p)+" ");
	}
}





// ADjency list appraoch 
// But we cant use it as the test cases are set accoding to the adjency matrix only
/*
Eg test case where adjency list is not working
4 4
0 3 
0 1
2 3
2 1
0 2

*/
/*public class _03GetPathDFS{
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a , int b){
		ArrayList<Integer> list = graph.get(a);
		list.add(b);
		list = graph.get(b);
		list.add(a);
	}
	public static ArrayList<Integer> getPathDFS(ArrayList<ArrayList<Integer>> graph,int v1,int v2){
		boolean visited[] = new boolean[graph.size()];
		visited[v1] = true;
		ArrayList<Integer> ans = getPathDFS(graph,v1,v2,visited);
		if(ans != null)
			ans.add(v1);
		return ans;
	}
	public static ArrayList<Integer> getPathDFS(ArrayList<ArrayList<Integer>>graph,int v1,int v2,boolean[] visited){
		ArrayList<Integer>list  = graph.get(v1);
		for(int i = 0;i < list.size();i++){
			int vertex = list.get(i);
			if(vertex == v2){
				ArrayList<Integer> ans = new ArrayList<>();
				ans.add(vertex);
				return ans;
			}
			if(!visited[vertex]){
				visited[vertex] = true;
				ArrayList<Integer> ans = getPathDFS(graph,vertex,v2,visited);
				if(ans != null){
					ans.add(vertex);
					return ans;
				}
			}
		}
		return null;
	}
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i < V;i++)
			graph.add(new ArrayList<Integer>());
		for(int i = 0;i < E;i++){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			addEdge(graph,a,b);
		}
		int v1 = scanner.nextInt();
		int v2 = scanner.nextInt();
		ArrayList<Integer> list  = getPathDFS(graph,v1,v2);
		if(list != null)
			for(int i:list)
				System.out.print(i+" ");
	}
}	*/