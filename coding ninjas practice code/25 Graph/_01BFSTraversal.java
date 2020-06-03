import java.util.*;
public class _01BFSTraversal{
	
	public static void bfsTraversal(int [][]adjMatrix){
		boolean visited[] = new boolean[adjMatrix.length];
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0 ;i < visited.length;i++){
			if(!visited[i]){
				visited[i] = true;
				queue.offer(i);
				while(!queue.isEmpty()){
					int item = queue.poll();
					System.out.print(item+" ");
					for(int j = 0 ;j < adjMatrix.length;j++){
						if(adjMatrix[item][j] == 1 && !visited[j]){
							visited[j] = true;
							queue.offer(j);
						}
						
					}
				}
			}
		}
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		int adjMatrix[][] = new int[V][V];
		for(int i = 0 ;i < E;i++){
			int a = s.nextInt();
			int b = s.nextInt();
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1; 
		}
		bfsTraversal(adjMatrix);

	}
	 
}