import java.util.*;
public class _06AllConnectedComponents{
	
	public static ArrayList<ArrayList<Integer>> allConnectedComponents(int adjMatrix[][]){
		boolean visited[] = new boolean[adjMatrix.length];
		Queue<Integer>queue = new LinkedList<Integer>();
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0;i < visited.length ;i++){
			ArrayList <Integer> smallAns = new ArrayList<>();
			if(!visited[i]){
				visited[i] = true;
				queue.offer(i);
				while(!queue.isEmpty()){
					int vertex =  queue.poll();
					smallAns.add(vertex);
					for(int j  = 0 ;j < adjMatrix.length;j++){
						if(!visited[j] && adjMatrix[vertex][j] == 1){
							visited[j] = true;
							queue.offer(j);
						}
					}	
				}
				ans.add(smallAns);
			}
			
		}
		return ans;
	}
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		int adjMatrix[][] = new int[V][V];
		for(int e = 0;e < E;e++){
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			adjMatrix[v1][v2] = adjMatrix[v2][v1] = 1;
		}
		ArrayList<ArrayList<Integer>> ans = allConnectedComponents(adjMatrix);
		for (int i = 0; i < ans.size(); i++) {
			ArrayList<Integer> list = ans.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j)+" ");
			}
			System.out.println();
		}
	}
}