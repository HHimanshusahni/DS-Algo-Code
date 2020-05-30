import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
//https://www.geeksforgeeks.org/shortest-uncommon-subsequence/
public class _18ShortestSubsequence{
	public static int solve(String S, String V){
		return solve(S,V,0,0);
	}
	public static int solve(String S, String V,int i,int j ){
		//Base Case
		if(j == V.length())
			return 1; // Important don't return  Integer.MAX_VALUE or S.length() - i
		if(i == S.length()) 
			return Integer.MAX_VALUE;

		//If we don't include the ith character in the answer
		int option1 = solve(S,V,i+1,j);
		
		//If we include the ith character in the answer then we need to search it in the string V
		boolean flag  = false;
		int x ;
		for(x = j ;x < V.length() ;x++){
			if(S.charAt(i) == V.charAt(x)){
				flag = true;
				break;
			}
		}
		int option2 = 1 ;
		if(flag){
			int value  =  solve(S,V,i + 1,x + 1); 
			if(value != Integer.MAX_VALUE)
				option2 = 1 + value;
			else
				option2 = Integer.MAX_VALUE;
		}
		return Math.min(option1 ,option2);
	} 

	//Memoization approach using dp array giving TLE
	static int dp[][];
	public static int solve_Mem(String S, String V){
		 dp = new int[S.length() + 1][V.length()+ 1];
		for(int i = 0 ;i <= S.length();i++)
			Arrays.fill(dp[i],0,V.length()+1,-1);
		return solve(S,V,0,0);
	}
	public static int solve_Mem(String S, String V,int i,int j ){
		//Base Case
		if(j == V.length())
			return 1; // Important don't return  Integer.MAX_VALUE or S.length() - i
		if(i == S.length()) 
			return Integer.MAX_VALUE;
		if(dp[i][j] != -1)
			return dp[i][j];
		//If we don't include the ith character in the answer
		int option1 = solve_Mem(S,V,i+1,j);
		
		//If we include the ith character in the answer then we need to search it in the string V
		boolean flag  = false;
		int x ;
		for(x = j ;x < V.length() ;x++){
			if(S.charAt(i) == V.charAt(x)){
				flag = true;
				break;
			}
		}
		int option2 = 1 ;
		if(flag){
			int value  =  solve_Mem(S,V,i + 1,x + 1); 
			if(value != Integer.MAX_VALUE)
				option2 = 1 + value;
			else
				option2 = Integer.MAX_VALUE;
		}
		return dp[i][j] = Math.min(option1 ,option2);
	} 
	//Memoization approach using HashMap --> TLE
	static HashMap<String , Integer> map;
	public static int solve_Mem_2(String S, String V){
		map = new HashMap<String,Integer>();
		return solve(S,V,0,0);
	}
	public static int solve_Mem_2(String S, String V,int i,int j ){
		//Base Case
		if(j == V.length())
			return 1; // Important don't return  Integer.MAX_VALUE or S.length() - i
		if(i == S.length()) 
			return Integer.MAX_VALUE;
		String key = S.substring(i)+" "+V.substring(j);
		if(map.containsKey(key))
			return map.get(key);
		//If we don't include the ith character in the answer
		int option1 = solve_Mem_2(S,V,i+1,j);
		
		//If we include the ith character in the answer then we need to search it in the string V
		boolean flag  = false;
		int x ;
		for(x = j ;x < V.length() ;x++){
			if(S.charAt(i) == V.charAt(x)){
				flag = true;
				break;
			}
		}
		int option2 = 1 ;
		if(flag){
			int value  =  solve_Mem_2(S,V,i + 1,x + 1); 
			if(value != Integer.MAX_VALUE)
				option2 = 1 + value;
			else
				option2 = Integer.MAX_VALUE;
		}

		int temp =   Math.min(option1 ,option2);
		map.put(key,temp);
		return temp;
	} 

	//Bottom Up Approach Time Compelxity O(m x n ^2) Space Complexity : O(m x n)
	public static int solve_BottomUp(String S, String V){
			int m = S.length();
		int n = V.length();
		int dp[][] = new int[m + 1][n + 1];
		for(int j = 0 ;j <= n ;j++){
			dp[m][j] = Integer.MAX_VALUE;
		}
		for(int i = 0 ;i < m; i++){
			dp[i][n] = 1;
		}

		for(int i = m - 1;i >=0; i--){
			for(int j = n - 1 ;j >=0 ;j--){
				int option1 = dp[i+1][j];//don't include it
				//Include it
				//We need to search the character in the string
				int x ;
				for(x = j ;x < n;x++){
					if(S.charAt(i) == V.charAt(x))
						break;
				}
                int option2 ;
				if(x == n)
					option2 = 1;
                else{
                    int value = dp[i+1][x+1]; 
                    if(value != Integer.MAX_VALUE)
                        option2 = 1 + value;
                    else
                        option2 = value;
                }
                    
				dp[i][j] = Math.min(option1,option2);
			}
		}
		return dp[0][0];
	}

	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		String S = scanner.next();
		String V = scanner.next();

		System.out.println(solve_BottomUp(S,V));
	}
}