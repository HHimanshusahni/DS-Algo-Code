import java.io.*;
class Pair{
	boolean ans ;
	char winner;
	Pair(boolean ans , char winner){
		this.ans = ans;
		this.winner = winner;
	}
}
public  class _17CoinTower{
	//time complexity exponential TLE error
	public  static String solve(int n,int x,int y){
	
		if(solve_help(n , x, y,'B').winner == 'B')
			return "Beerus";
		else
			return "Whis";	
	}
	public static Pair solve_help(int n , int x , int y ,char winner){
		//Base Case
		if(n == 1 || n == x || n == y)
			return new Pair(true,winner); 
		if(n < 0 )
			return new Pair(false,'N');
		char winner_2 ;
		if(winner =='B')
			winner_2 = 'W';
		 else
		 	winner_2 = 'B';
		 if(solve_help(n - 1,x,y,winner_2).ans && 
		 	solve_help(n - x , x , y ,winner_2).ans && 
		 	solve_help(n - y , x , y , winner_2).ans)
		 	return new Pair(false,winner_2);
		 else
		 	return new Pair(true,winner);

	}

	//Memoization Stack over flow eror O(n)
	static Pair dp[] ;
	public  static String solve_Mem(int n,int x,int y){
		 dp = new Pair[n+1];
		if(solve_help_2(n , x, y,'B').winner == 'B')
			return "Beerus";
		else
			return "Whis";	
	}
	public static Pair solve_help_2(int n , int x , int y ,char winner){
		//Base Case
		if(n == 1 || n == x || n == y)
			return new Pair(true,winner); 
		if(n < 0 )
			return new Pair(false,'N');

		if(dp[n] != null)
			return dp[n];
		char winner_2 ;
		if(winner =='B')
			winner_2 = 'W';
		 else
		 	winner_2 = 'B';
		 if(solve_help_2(n - 1,x,y,winner_2).ans && 
		 	solve_help_2(n - x , x , y ,winner_2).ans && 
		 	solve_help_2(n - y , x , y , winner_2).ans)
		 	return dp[n] = new Pair(false,winner_2);
		 else
		 	return dp[n] = new Pair(true,winner);

	}
	//Bottom Up
	public  static String solve_bottomUp(int n,int x,int y){
		Boolean dp[] = new Boolean[n + 1];
		//True :Beerus False : Whis
		dp[1] =  true;
		dp[x] =  true;
		dp[y] =  true;
		boolean t1  , t2;
		for(int i = 2 ;i <= n;i++){
			if(i != x  && i != y){
				t1 = true;
				t2 = true;
				if(i - x >= 1)
					t1 = dp[i - x];
				if(i - y >=1 )	
					t2 = dp[i - y];

				dp[i] = !(dp[i - 1] && t1 && t2);
			}
		}
		if(dp[n])
			return "Beerus";
		else
			return "Whis";
	}
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int x = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[2]);
		System.out.println(solve_bottomUp(n,x,y));
	}
}