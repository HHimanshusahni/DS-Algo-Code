import java.util.*;
public class _04GetPathBFS{
	public static ArrayList<Integer>getPathBFS(int adjMatrix[][],int v1,int v2){
		boolean visited[] = new boolean[adjMatrix.length];
		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		queue.offer(v1);
		visited[v1] = true;
		boolean flag = false;
		while(!queue.isEmpty() ){
			int vertex = queue.poll();
			if(vertex == v2){
				flag = true;
				break;
			}
			for(int i = 0;i < adjMatrix.length;i++){
				if(adjMatrix[vertex][i] == 1 && !visited[i]){
					visited[i] = true;
					queue.offer(i);
					map.put(i,vertex);
				}
			}
		}
		if(!flag)
			return null;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(v2);
		int key = v2;
		while(true){
			if(key == v1)
				break;
			int vertex = map.get(key);
			ans.add(vertex);
			key = vertex;
		}
		return ans;
	}
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		int adjMatrix[][] = new int[V][V];
		for(int e = 0;e < E;e++){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;
		}
		int v1 = scanner.nextInt();
		int v2 = scanner.nextInt();
		ArrayList<Integer> ans = getPathBFS(adjMatrix,v1,v2);
		if(ans != null)
			for(int i = 0;i <ans.size();i++)
				System.out.print(ans.get(i)+" ");
	}
}