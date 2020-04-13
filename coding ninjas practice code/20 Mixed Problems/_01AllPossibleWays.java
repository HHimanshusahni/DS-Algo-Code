import java.util.Scanner;
public class _01AllPossibleWays{

	//Recursive approach time complexity is exponential can do better with dynamic programming
	public static int allWays(int x, int n) {
		return allWays(x,1,n);
	}

	public static int allWays(int sum ,int num, int power){
		//Base Case
		if(sum == 0 )
			return 1 ;
		else if(sum < 0 || num > sum)
			return 0;

		//Recursive Case
		//If include the num in the answer
		int option1 = allWays(sum - (int)Math.pow(num,power),num+1,power); // Math.pow() return double value so type cast it

		//If we don't include the num in the answer 
		int option2 = allWays(sum,num +1 ,power);


		//Small Calculation
		return option1 + option2;

	}

	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a ");
		int a = s.nextInt();
		System.out.println("Enter  b");
		int b = s.nextInt();
		System.out.println("Count all Ways  "+allWays(a,b));
	}
}