import java.util.*;
public class _05IsConnected{
	public static void addEdge(ArrayList<ArrayList<Integer>>adjList,int v1,int v2){
		ArrayList<Integer> list = adjList.get(v1);
		list.add(v2);
		list = adjList.get(v2);
		list.add(v1);
	}	
	public static boolean isConnected(ArrayList<ArrayList<Integer>>adjList){
		boolean visited[] = new boolean[adjList.size()];
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		visited[0] = true;
		while(!q.isEmpty()){
			int element = q.poll();;
			ArrayList<Integer> vertices = adjList.get(element);
			for(int i = 0;i < vertices.size();i++){
				int vertex = vertices.get(i);
				if(!visited[vertex]){
					visited[vertex] = true;
					q.offer(vertex);
				}
			}
		}
		for(int i = 0;i < visited.length;i++){
			if(!visited[i])
				return false;
		}
		return true;
	}
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i = 0;i < V;i++){
			adjList.add(new ArrayList<Integer>());
		}
		for(int i = 0;i < E;i++){
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			addEdge(adjList,v1,v2);
		}
		System.out.println(isConnected(adjList));
	}
}