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
	
	
	
	
	//Memoization approach 3d dp solution
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < test;t++){
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
//			map.clear();
			System.out.println(noOfWays_3(s,0,n - 1,true));
		}

	}

}
