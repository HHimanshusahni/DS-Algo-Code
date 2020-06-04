import java.util.*;
public class _00DFSTraversal{
//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
//https://www.youtube.com/watch?v=CvUMf8c2JFo
	static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       // add your code here
       boolean visited[] = new boolean [N];    
       ArrayList<Integer>ans = new ArrayList<Integer>();
       dfs_1(0,g,visited,ans);
       return ans; 
    }
    static void  dfs_1(int start,ArrayList<ArrayList<Integer>> g,boolean visited[],ArrayList<Integer>ans){
        
            visited[start] = true;
            ans.add(start);
            for(int i = 0;i <g.get(start).size() ;i++){
                int vertex = g.get(start).get(i);
                if(!visited[vertex]){
                    dfs_1(vertex,g,visited,ans);
                }
            }
    }
    public static void main(String[]args){
    	Scanner s = new Scanner(System.in);
    	int testCase = s.nextInt();

    	for(int t = 0 ;t < testCase;t++){
    		int n = s.nextInt();
    		int e = s.nextInt();
    		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    		for(int j = 0;j < n;j++)
    			list.add( new ArrayList<Integer>());
    		for(int j = 0 ;j < e;j++){
    			int vertex1 = s.nextInt();
    			int vertex2 = s.nextInt();

    			ArrayList<Integer>li = list.get(vertex1);
    			li.add(vertex2);
    			li = list.get(vertex2);
    			li.add(vertex1);
    		}
    		ArrayList<Integer> ans = dfs(list,n);
    		for(int i:ans)
    			System.out.print(i+" ");
    		System.out.println();
    	}
    }
    
}