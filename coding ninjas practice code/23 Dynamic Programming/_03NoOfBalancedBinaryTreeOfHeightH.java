import java.io.*;
import java.util.*;
public class _03NoOfBalancedBinaryTreeOfHeightH{
	//Recursive Approach T(n) = T(n-1)+T(n-2) ==> 2^n ~ Exponential time complexity
	public static final int m =(int)(Math.pow(10,9)+7) ;
	public static int balancedTreesOfHeightH(int height){
		//Base Case
		if(height == 1)
			return 1;
		if(height == 2)
			return 3;
		int h1 = balancedTreesOfHeightH(height -1);
		int h2 = balancedTreesOfHeightH(height -2);
		// Tree(height h) = (Trees(height -1 ) x Trees(height - 2))^2  - Tree(height -2 )^2
		// (t(h1) + t(h2)) ^2  - t(h2)^2 == Trees(h1 ^2) + 2 x h1 x h2) == > Trees(h1(h1 + 2h2)
        
        long a = h1;
        long b = h2;
        int part1 = (int)( ( a * a ) % m );
        int part2 = (int)( (a * b * 2) % m );
        return (part1 + part2)%m;
		/*It is very important to note that
		  --> We are using modular arithmetic here and its properties As after mutliplication
		   Then after taking the mod we type cast it back to (int) 
		*/
	}

	//Memoization Approach  Time complexity: O(height) as these  space complexity O(height) + stack space of O(height)
	static int dp[];
	public static int balancedTreesOfHeightH_2(int height){
		dp = new int[height+1];
		for(int i = 0 ;i < dp.length;i++)
			dp[i] = -1;
		return balancedTreesOfHeightH_Mem(height);
	}
	private static int balancedTreesOfHeightH_Mem(int height){
	//Base Case{
		if(height == 1)
			return 1;
		if(height == 2)
			return 3;
		if(dp[height] != -1)
			return dp[height];
		int h1 = balancedTreesOfHeightH_Mem(height -1);
		int h2 = balancedTreesOfHeightH_Mem(height -2);
        
        long a = h1;
        long b = h2;
        int part1 = (int)( ( a * a ) % m );
        int part2 = (int)( (a * b * 2) % m );
        return dp[height] = (part1 + part2) % m;
	}
	//Bottom Up Approach Time complexity: O(height) as these  space complexity O(height)
	public static int balancedTreesOfHeightH_BottomUp(int height){
		if(height == 1)
			return 1;
		if(height == 2)
			return 3;
		int dp[] = new int[height + 1];
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3 ;i < dp.length;i++){
			long a = dp[i - 1];
			long b = dp[i - 2];
			int part1 = (int)( ( a * a ) % m );
            int part2 = (int)( (a * b * 2) % m );
            dp[i] = (part1 + part2) % m;
		}
		return dp[height];
	}
	//Time complexity: O(height)  space complexity: O(1) Without dp array
	public static int balancedTreesOfHeightH_BottomUpOptimized(int height){
		int t1 = 1;
		int t2 = 3;
		if(height == 1)
			return t1;
		if(height == 2)
			return t2;
		
		for(int i = 3 ;i <= height;i++){
			long a = t2 ;
			long b = t1 ;
			t1 = t2;
			int part1 = (int)( ( a * a ) % m );
            int part2 = (int)( (a * b * 2) % m );
            t2 = (part1 + part2) % m;
       
		}
		return t2;
	}

	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = Integer.parseInt(br.readLine());
		System.out.println(balancedTreesOfHeightH_BottomUpOptimized(h));
		
	}
}