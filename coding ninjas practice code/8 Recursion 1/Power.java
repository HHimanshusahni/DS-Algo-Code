public class Power{

	//O(n)  Recurrence relation : T(n) = T(n-1) + 1
	public static int power(int x, int n){
		if(n==0)
			return 1;
		return x * power(x,n-1);
	}


	//Divide and conquer
	// O(n) Recurrence Relation : T(n)  = 2T(n/2) + 1
	public static int power_2(int x, int n){
		// base case
		if(n==0)
			return 1;
		if(n%2==0)
			return power_2(x,n/2) * power_2(x,n/2); // recursive call
		else 
			return x * power_2(x,n/2) * power_2(x,n/2);

	}


	// 0(log n)   Recurrence Relation : T(n)  = T(n/2) + 1
	public static int power_3(int x , int n ){
		if(n==0)
			return 1;
		int smallAns = power_3(x,n/2); // recursive call

		if(n%2==0)
			return smallAns * smallAns;
		else 
			return x * smallAns * smallAns;
	}
	
	public static void main(String[] args){
		System.out.println(power_3(3,4));
	}
}