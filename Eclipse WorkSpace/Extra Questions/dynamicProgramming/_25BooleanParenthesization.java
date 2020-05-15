package dynamicProgramming;
import java.io.*;
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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < test;t++){
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			System.out.println(noOfWays(s,0,n - 1,true)%1003);
		}

	}

}
