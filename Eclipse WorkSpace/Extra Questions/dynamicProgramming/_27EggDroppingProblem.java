package dynamicProgramming;
import java.io.*;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0
//https://www.includehelp.com/algorithms/egg-dropping-problem-using-dynamic-programming.aspx
public class _27EggDroppingProblem {
	
	
	/*Wrong binary search approach i have tried this is wrong
	 * Corret appraoch link : https://www.geeksforgeeks.org/eggs-dropping-puzzle-binomial-coefficient-and-binary-search-solution/
	 * public static int solve(int eggs , int floor){
        int attempts = 0 ;
        int flag = true;
        while(eggs > 1 ){
            attempts++;
            floor = floor - (floor/2) -1;
            eggs--;
            if(floor == 0)}{
                flag = false;
                break;
            }
        }
        if(flag)
        attempts += floor;
       return attempts 
    }
	 * */
	//Recursive approach Exponential time complexity 
	public static int findMinimumTrails(int eggs,int floors){
		//Base Case
		if(floors <= 1)
			return floors;
		//if there is one egg then we need to go each floor in worst case and drop the egg to check
		if(eggs == 1)
			return floors;
		
		//Small Calculation and recursive Case
		int tempAns1 , tempAns2  ,tempAns, minAns = Integer.MAX_VALUE;
		//we will try to drop the egg from each floor k and see what is the minimum answer
		for(int k = 1;k <= floors;k++ ){
			//Case 1 : The egg breaks after dropping , the no of eggs reduces by 1 & we need to check in the below floors
			tempAns1 = findMinimumTrails(eggs - 1,k-1);
			//Case 2 : The egg doesn't breaks after dropping , then the eggs remains same but we need to check in above floors
			tempAns2 = findMinimumTrails(eggs,floors - k);
			
			//As we need to find the worst case we are finding the maximum of all the cases that can occur
			tempAns = 1 + Math.max(tempAns1,tempAns2);
			
			//Ans as we need to minimize the attempts we are taking the minimum of all the tempAns
			minAns =  Math.min(minAns,tempAns);
		}
		return minAns;
	}
	//Memoization appraoch
	static int dp[][] = new int[31][51]; // 1 <= eggs <=31  1 <= floors <= 51 
	
	public static int findMinimumTrails_Mem(int eggs, int floors){
		//intialize the dp array with -1 to indicate the value is not yet calculated
		for(int i = 0 ; i <= eggs ;i++){
			Arrays.fill(dp[i],0,floors + 1,-1);
		}
		return findMinimumTrails_2(eggs,floors);
	}
	public static int findMinimumTrails_2(int eggs,int floors){
		//Base Case
		if(floors <= 1)
			return floors;
		//if there is one egg then we need to go each floor in worst case and drop the egg to check
		if(eggs == 1)
			return floors;
		
		//Check if the value is already present in the dp array
		if(dp[eggs][floors] != -1)
			return dp[eggs][floors] ;
		//Small Calculation and recursive Case
		int tempAns1 , tempAns2  ,tempAns, minAns = Integer.MAX_VALUE;
		//we will try to drop the egg from each floor k and see what is the minimum answer
		for(int k = 1;k <= floors;k++ ){
			//Case 1 : The egg breaks after dropping , the no of eggs reduces by 1 & we need to check in the below floors
			tempAns1 = findMinimumTrails(eggs - 1,k-1);
			//Case 2 : The egg doesn't breaks after dropping , then the eggs remains same but we need to check in above floors
			tempAns2 = findMinimumTrails(eggs,floors - k);
			
			//As we need to find the worst case we are finding the maximum of all the cases that can occur
			tempAns = 1 + Math.max(tempAns1,tempAns2);
			
			//Ans as we need to minimize the attempts we are taking the minimum of all the tempAns
			minAns =  Math.min(minAns,tempAns);
		}
		//Storing the value in the dp matrix as it is not calculated before
		return dp[eggs][floors]  = minAns;
	}
	
	
	//Bottom Up Approach
	public static int findMinimumTrails_bottomUp(int eggs,int floors){
		int dp[][] = new int[eggs + 1][floors + 1];
		
		for(int i = 0 ;i <= eggs; i++){
			//if floors are zero or 1 
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		for(int j = 0 ; j <= floors ;j++){
			dp[0][j] = 0;
			//If the no of eggs are 1 then in worst case we need to go to all the floors
			dp[1][j] = j;
		}
		
		for(int i = 2 ;i <= eggs ;i++ ){
			for(int j = 2 ;j <= floors ;j++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = 1;k <= j ;k++){
					int tempAns = 1 + Math.max(dp[i-1][k-1],dp[i][j-k]);
					dp[i][j] = Math.min(tempAns,dp[i][j]);
				}
			}
			
		}
	
		return dp[eggs][floors];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T; t++){
			String strArr[] = br.readLine().split(" ");
			int eggs = Integer.parseInt(strArr[0]);
			int floors = Integer.parseInt(strArr[1]);
			System.out.println(findMinimumTrails_bottomUp(eggs,floors));
		}

	}

}
