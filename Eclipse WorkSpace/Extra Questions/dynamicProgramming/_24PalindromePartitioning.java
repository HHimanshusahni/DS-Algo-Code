package dynamicProgramming;
import java.io.*;
import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/palindromic-patitioning/0
//The problem is similar to matrix chain multiplication
public class _24PalindromePartitioning {
	//Recursive Code Palindrome Partitioning
	public static int palindromePartition(String s , int i , int j ){
		//Base Case
		//If the string is empty or having one element then it is already palindrome so 0 partitions
		if(i >= j)
			return 0;
		//If the current string is itself palindrome then also no need to check
		if(isPalindrome(s,i,j))
			return 0;
		int ans = Integer.MAX_VALUE, tempAns ;
		for(int k = i ;k <= j-1 ;k++){
			tempAns = palindromePartition(s, i, k) + 
					  palindromePartition(s, k + 1, j) + 1;
			ans = Math.min(tempAns, ans);
		}
		return ans;
	}
	//Memoization
	static int dp[][] = new int[1001][1001];
	public static int palindromePartition_2(String s , int i , int j ){
		for(int x = 0 ;x < s.length() + 1;x++)
			Arrays.fill(dp[x],0,s.length() + 1,-1);
		return palindromePartition_Memo(s, i, j);
	}
	public static int palindromePartition_Memo(String s , int i , int j ){
		//Base Case
		//If the string is empty or having one element then it is already palindrome so 0 partitions
		if(i >= j)
			return 0;
		if(dp[i][j] != -1)
			return dp[i][j];
		//If the current string is itself palindrome then also no need to check
		if(isPalindrome(s,i,j))
			return 0;
		int ans = Integer.MAX_VALUE, tempAns ;
		for(int k = i ;k <= j-1 ;k++){
			tempAns = palindromePartition_Memo(s, i, k) + 
					  palindromePartition_Memo(s, k + 1, j) + 1;
			ans = Math.min(tempAns, ans);
		}
		return dp[i][j] = ans;
	}
	
	
	//Memoization Optimization
	//Before making the functions calls check the value is already present in dp table
//		static int dp[][] = new int[1001][1001];
		public static int palindromePartition_3(String s , int i , int j ){
			for(int x = 0 ;x < s.length() + 1;x++)
				Arrays.fill(dp[x],0,s.length() + 1,-1);
			return palindromePartition_MemoOptimized(s, i, j);
		}
		public static int palindromePartition_MemoOptimized(String s , int i , int j ){
			//Base Case
			//If the string is empty or having one element then it is already palindrome so 0 partitions
			if(i >= j)
				return 0;
			if(dp[i][j] != -1)
				return dp[i][j];
			//If the current string is itself palindrome then also no need to check
			if(isPalindrome(s,i,j))
				return 0;
			int ans = Integer.MAX_VALUE, tempAns,left,right;
			for(int k = i ;k <= j-1 ;k++){
				if(dp[i][k] != -1)
					left = dp[i][k];
				else
					left = dp[i][k] = palindromePartition_MemoOptimized(s, i, k) ;
				
				if(dp[k+1][j] != -1)
					right = dp[k+1][j];
				else 
					right = dp[k+1][j] = palindromePartition_MemoOptimized(s, k + 1, j);
						  
				tempAns  = left + right +1;
				ans = Math.min(tempAns, ans);
			}
			return dp[i][j] = ans;
		}
	public static boolean isPalindrome(String s , int i , int j ){
		int x = i , y = j;
		while(x < y){
			if(s.charAt(x++) !=  s.charAt(y--))
				return false;
		}
		return true;
	} 
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < testCase; t++){
			String s = br.readLine();
			System.out.println(palindromePartition_3(s,0,s.length()-1));
		}
	}
}
