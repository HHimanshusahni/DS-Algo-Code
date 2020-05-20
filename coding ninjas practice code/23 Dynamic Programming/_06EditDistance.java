import java.io.*;
public class _06EditDistance{

	//Recursive Approach
	public static int editDistance(String s1, String s2){
		//Base Case 
		if(s1.length() == 0 )
			return s2.length();
		if(s2.length() == 0)
			return s1.length();
		//Recursive Case
		
		//If both the characters match we need not do modification
		if(s1.charAt(0) == s2.charAt(0))
			return editDistance(s1.substring(1),s2.substring(1));

		//Don't match We need to perform one of the operation
 		int option1 = editDistance (s1.substring(1),s2);
		int option2 = editDistance (s1,s2.substring(1));
		int option3 = editDistance (s1.substring(1),s2.substring(1));

		return 1 + Math.min(option1,Math.min(option2,option3));
			
	}
	//Recursive Approach 
	//with i and j correponding to the lengths 
	//& we are comparing considering the last character Time complexity :  exponential~ ( 3 ^ (m+n))
	public static int editDistance_1(String s1,String s2){
		return editDistance_1(s1,s2,s1.length(),s2.length());
	}
	public static int editDistance_1(String s1, String s2,int i , int j ){
		//Base Case
		if(i == 0)
			return j;
		if(j == 0)
			return i;
		//If the character matches
		if(s1.charAt(i-1) == s2.charAt(j-1))
			return editDistance_1(s1,s2,i-1,j-1);
		//If the character don't matches
		int option1 = editDistance_1(s1,s2,i - 1,j);
		int option2 = editDistance_1(s1,s2,i,j - 1);
		int option3 = editDistance_1(s1,s2,i - 1,j - 1);
		return 1 + Math.min(option1,Math.min(option2,option3));
		
	}

	//Memoization ja+ stack space
	static int dp[][] ;
	public static int editDistance_2(String s1,String s2){
		dp = new int[s1.length()+1][s2.length()+1];
		for(int i = 0 ;i <= s1.length() ;i++)
			for(int j = 0 ;j <= s2.length();j++)
				dp[i][j] = -1;
		return editDistance_2(s1,s2,s1.length(),s2.length());
	}
	public static int editDistance_2(String s1, String s2,int i , int j ){
		//Base Case
		if(i == 0)
			return j;
		if(j == 0)
			return i;
		if(dp[i][j] != -1)
			return dp[i][j];

		//If the character matches
		if(s1.charAt(i-1) == s2.charAt(j-1))
			return editDistance_2(s1,s2,i-1,j-1);
		//If the character don't matches
		int option1 = editDistance_2(s1,s2,i - 1,j);
		int option2 = editDistance_2(s1,s2,i,j - 1);
		int option3 = editDistance_2(s1,s2,i - 1,j - 1);
		return dp[i][j] = 1 + Math.min(option1,Math.min(option2,option3));
		
	}

	//Bottom Up Approach Time Complexity : O(m x n) Space Complexity : O(m x n)
	public static int editDistance_3(String s1 , String s2){
		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m + 1][n + 1];
		// if s1 is empty string then we need to delete all the characters of s2 to get s1
		for(int j = 0 ;j <= n ;j++)
			dp[0][j] = j;
		//if s2 is empty string then we need to delete all the characters of s1 to get s2
		for(int i = 0 ; i <= m ;i++)
			dp[i][0] = i;

		for(int i = 1;i <= m;i++){
			for(int j = 1;j <= n ;j++){
				if(s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j]  = dp[i-1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
			}
		}
		return dp[m][n];

	}
	//Bottom Up 1d array approach Time Complexity : O( m x n ) Space Complexity : O(n)
	public static int editDistance_4(String s1 , String s2){
			int m = s1.length();
		    int n = s2.length();
		    int dp[] = new int[n + 1];
		    //If the s1 length is  equal to 0 then it takes s2 length deletions 
		    for(int j = 0 ;j <= n ;j++)
		    	dp[j] = j;

		    for(int i = 1;i <= m ;i++){
		    	int diagonal = i - 1; 
		    	dp[0] = i;
		    	for(int j = 1;j <= n ;j++){
		    		int temp = dp[j];
		    		//There is a match
		    		if(s1.charAt(i-1) == s2.charAt(j-1))
		    			dp[j] = diagonal;
		    		else
		    			dp[j] = 1 + Math.min(dp[j - 1],Math.min(diagonal,dp[j]));
		    		diagonal = temp;
		    	}
		    }
		    return dp[n];
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		System.out.println(editDistance_4(s1,s2));
	}
}