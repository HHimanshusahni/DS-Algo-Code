import java.util.*;
public class _02HasPath{
	//adjency list approach
	public static void addEdge(ArrayList<ArrayList<Integer>>graph,int vertex1,int vertex2){
		ArrayList<Integer>list = graph.get(vertex1);
		list.add(vertex2);
		list = graph.get(vertex2);
		list.add(vertex1);
	}

	public static boolean hasPath_bfs(ArrayList<ArrayList<Integer>>graph,int vertex1,int vertex2){
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[graph.size()];
		queue.offer(vertex1);
		visited[vertex1] = true;
		while(!queue.isEmpty()){
			int vertex = queue.poll();
			if(vertex == vertex2)
				return true;
			ArrayList<Integer> list = graph.get(vertex);
			for(int v :list){
				if(!visited[v]){
					visited[v] = true;
					queue.offer(v);
				}
			}

		}
		return false;
	}
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		
		ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
		for(int i = 0;i < V;i++)
			graph.add(new ArrayList<Integer>());
		for(int i = 0;i < E;i++){
			int vertex1 = scanner.nextInt();
			int vertex2 = scanner.nextInt();
			addEdge(graph,vertex1,vertex2);
		}
		int vertex1 = scanner.nextInt();
		int vertex2 = scanner.nextInt();
		System.out.println(hasPath_bfs(graph,vertex1,vertex2));
	}
}