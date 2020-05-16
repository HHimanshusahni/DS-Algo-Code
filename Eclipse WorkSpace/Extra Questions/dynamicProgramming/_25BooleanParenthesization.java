package dynamicProgramming;
import java.io.*;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/boolean-parenthesization/0

public class _25BooleanParenthesization {
	//Recursive Approach
	public static int noOfWays(String s , int i , int j , boolean isTrue){
		//Base Case
		if(i > j){
			return 0;
		}
		if(i == j){
			if(isTrue){
				if(s.charAt(i) == 'T')
					return 1;
				else 
					return 0;
			}else{
				if(s.charAt(i) == 'F')
					return 1;
				else
					return 0;
			}
		}
		char ch ;
		int ans  = 0,tempAns = 0;
		for(int k = i + 1;k < j ;k = k + 2){
			int lT = noOfWays(s, i, k - 1, true);
			int lF = noOfWays(s, i, k - 1, false);
			int rT = noOfWays(s, k + 1, j, true);
			int rF = noOfWays(s, k + 1, j, false);
			ch = s.charAt(k);
			if(ch == '&'){
				if(isTrue){
					tempAns = lT * rT;
				}else{
					tempAns = lF * rF + lT * rF + lF * rT  ;
				}
			}else if(ch == '^'){
				if(isTrue){
					tempAns = lF * rT + lT * rF;
				}else{
					tempAns = lF * rF + lT * rT;
				}
			}else if(ch == '|'){
				if(isTrue){
					tempAns = lT * rT + lF * rT + lT * rF;
				}else{
					tempAns = lF * rF;
				}
			}
			ans = ans + tempAns;
		}
		return  ans;
	}
	
	
	
	//Memoization Approach HashMap TLE
    static HashMap<String,Integer> map = new HashMap<>();
	public static int noOfWays_2(String s , int i , int j , boolean isTrue){
		//Base Case
		if(i > j){
			return 0;
		}
		if(i == j){
			if(isTrue){
				if(s.charAt(i) == 'T')
					return 1;
				else 
					return 0;
			}else{
				if(s.charAt(i) == 'F')
					return 1;
				else
					return 0;
			}
		}
		String key = i+" "+j+" "+isTrue;
		if(map.containsKey(key))
			return map.get(key);
		
		char ch ;
		int ans  = 0,tempAns = 0;
		for(int k = i + 1;k < j ;k = k + 2){
			int lT = noOfWays_2(s, i, k - 1, true);
			int lF = noOfWays_2(s, i, k - 1, false);
			int rT = noOfWays_2(s, k + 1, j, true);
			int rF = noOfWays_2(s, k + 1, j, false);
			ch = s.charAt(k);
			if(ch == '&'){
				if(isTrue){
					tempAns = lT * rT;
				}else{
					tempAns = lF * rF + lT * rF + lF * rT  ;
				}
			}else if(ch == '^'){
				if(isTrue){
					tempAns = lF * rT + lT * rF;
				}else{
					tempAns = lF * rF + lT * rT;
				}
			}else if(ch == '|'){
				if(isTrue){
					tempAns = lT * rT + lF * rT + lT * rF;
				}else{
					tempAns = lF * rF;
				}
			}
			ans = ans + tempAns;
		}
		map.put(key, ans%1003);
		return  ans%1003;
	}
	
	
	
	
	//Memoization approach 3d dp solution Execution time 1.26
	static int dp[][][] = new int[101][101][2];
	public static int noOfWays_3(String s , int i , int j , boolean isTrue){
		for(int x = 0 ;x <=j ;x++){
			for(int y = 0;y <=j ;y++){
				for(int z = 0; z <= 1 ;z++)
					dp[x][y][z] = -1;
			}
		}
		return noOfWays_mem(s,i,j,isTrue);
	}
	public static int noOfWays_mem(String s , int i , int j , boolean isTrue){
		//Base Case
		if(i > j){
			return 0;
		}
		if(i == j){
			if(isTrue){
				if(s.charAt(i) == 'T')
					return 1;
				else 
					return 0;
			}else{
				if(s.charAt(i) == 'F')
					return 1;
				else
					return 0;
			}
		}
		int z = isTrue ? 1 : 0;
		if(dp[i][j][z] != -1){
			return dp[i][j][z];
		}
		char ch ;
		int ans  = 0,tempAns = 0;
		for(int k = i + 1;k < j ;k = k + 2){
			int lT = noOfWays_mem(s, i, k - 1, true);
			int lF = noOfWays_mem(s, i, k - 1, false);
			int rT = noOfWays_mem(s, k + 1, j, true);
			int rF = noOfWays_mem(s, k + 1, j, false);
			ch = s.charAt(k);
			if(ch == '&'){
				if(isTrue){
					tempAns = lT * rT;
				}else{
					tempAns = lF * rF + lT * rF + lF * rT  ;
				}
			}else if(ch == '^'){
				if(isTrue){
					tempAns = lF * rT + lT * rF;
				}else{
					tempAns = lF * rF + lT * rT;
				}
			}else if(ch == '|'){
				if(isTrue){
					tempAns = lT * rT + lF * rT + lT * rF;
				}else{
					tempAns = lF * rF;
				}
			}
			ans = ans + tempAns;
		}
		return  dp[i][j][z] = ans;
	}
	//Bottom up Approach Execution time 0.86
	public static int noOfWays_4(String s){
		int n = s.length();
		int dp[][][] = new int[n][n][2];// 0 corresponds to false and 1 corresponds to true
		//For length 1 we are considering only true / false values
		for(int i = 0 ;i < n ;i = i + 2){
			if(s.charAt(i) == 'T'){
				dp[i][i][1] = 1 ;
				dp[i][i][0] = 0 ;
			}else{
				dp[i][i][1] = 0;
				dp[i][i][0] = 1;
			}
		}
		//we are considering the symbols
		for(int l = 3  ; l <= n ; l = l + 2){
			for(int i = 0 ; i < n - l + 1;i = i + 2){
				int j = i + l - 1;
				int tempAns0 = 0 , tempAns1 = 0;
				dp[i][j][0] = 0;
				dp[i][j][1] = 0;
				for(int k = i + 1;k < n ; k  = k + 2){
					int lT = dp[i][k-1][1];
					int lF = dp[i][k-1][0];
					int rT = dp[k + 1][j][1];
					int rF = dp[k+1][j][0];
					char ch = s.charAt(k);
					if(ch == '&'){
						tempAns1 = lT * rT;
						tempAns0 = lF * rF + lT * rF + lF * rT  ;
					}else if(ch == '^'){
						tempAns1 = lF * rT + lT * rF;
						tempAns0 = lF * rF + lT * rT;
					}else if(ch == '|'){
						tempAns1 = lT * rT + lF * rT + lT * rF;
						tempAns0 = lF * rF;
					}
					dp[i][j][1] = (dp[i][j][1]+tempAns1)%1003 ;
					dp[i][j][0] = (dp[i][j][0]+tempAns0)%1003 ;
					
				}
			}
		}

		return dp[0][n-1][1];

	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < test;t++){
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
//			map.clear();
//			System.out.println(noOfWays_4(s,0,n - 1,true));
			System.out.println(noOfWays_4(s));
		}

	}

}
