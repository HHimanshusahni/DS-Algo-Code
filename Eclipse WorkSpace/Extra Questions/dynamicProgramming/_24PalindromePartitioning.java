package dynamicProgramming;
import java.io.*;
import java.util.Arrays;
//https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
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
	//Bottom Approach Time Complexity : O(n ^4)
	//dp array we are using is global
	public static int palindromePartition_bottomUp(String s){
		int n = s.length();
		for(int x = 0 ; x < n;x++)
			dp[x][x] = 0;
		for(int length = 1 ;length < n  ;length++){
			for(int i = 0;i <= n - length -1 ; i++){
				int j = i + length;
				if(isPalindrome(s,i,j))
					dp[i][j] = 0;
				else{
					dp[i][j] = Integer.MAX_VALUE;
					for(int k = i ;k < j ;k++){
						int tempAns = dp[i][k] + dp[k+1][j]+1;
						dp[i][j] = Math.min(dp[i][j], tempAns);
					}
				}
			}
		}
		
		
//		for(int i = 0 ;i < n;i++){
//			for(int j = 0 ;j < n  ;j++){
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		return dp[0][n-1];
		
	}
	
	//Approach 
	//O(n^3),by finding string is palindrome or not in O(n^2)time in the above approach ==> O(n^3)+O(n^2) = O(n^3)
	//We can use the longest palindromic substring dp approach to find the substring is palindrome or not
	public static int palindromePartition_5(String s){
		int n = s.length();
		int dp[][] = new int[n][n];
		boolean palindrome[][] = new boolean[n][n];
		//for String of length 1
		for(int i = 0 ;i < n;i++){
			dp[i][i] = 0; // Because one length string require no partitioning
			palindrome[i][i] = true; //one length string is a palindrome			
		}
		int tempAns ;
		for(int length = 2;length <= n ;length++){

			for(int i = 0;i < n - length +1 ;i++){
				int j  = i + length -1;
				if(length == 2){
					palindrome[i][j] = s.charAt(i) == s.charAt(j);
				}else{
					palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]);
				}
				if(palindrome[i][j])
					dp[i][j] = 0;
				else{
					dp[i][j] = Integer.MAX_VALUE;
					for(int k = i ; k <= j-1;k++){
						tempAns = dp[i][k]+dp[k+1][j]+1;
						dp[i][j] = Math.min(dp[i][j],tempAns);
					}
				}
			}
		}
	
		return dp[0][n-1];
	}
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < testCase; t++){
			String s = br.readLine();
//			System.out.println(palindromePartition_3(s,0,s.length()-1));
			System.out.println(palindromePartition_5(s));
		}
	}
}
