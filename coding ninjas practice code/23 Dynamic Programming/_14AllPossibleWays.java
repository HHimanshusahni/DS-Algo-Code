import java.util.Scanner;
public class _14AllPossibleWays{

	//Recusive Approach Time Complexity : O(2 ^a)
	public static int allWays(int x , int n){
		return allWays(x,n,1);
	}
	private static int allWays(int sum , int pow , int value){
		//Base Case
		if(sum == 0)
			return 1;
		else if(sum < 0 || value > sum )
			return 0;
		//We have to option we include the current value in the sum
		int option1 = allWays(sum - (int)Math.pow(value,pow),pow,value +1 );

		//We don't include the current value in the sum
		int option2 = allWays(sum , pow,value + 1);

		return option1 + option2;
	}

	public static void main(String[]args){
		Scanner s = new Scanner(System.in)
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(allWays(a,b));
	}
}