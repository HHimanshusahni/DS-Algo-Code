public class PrintNumbers {

	public static void main(String[] args){
		print(5);
	}
	public static void print(int n){
		if(n == 1){
			System.out.print(n + " ");
            return;
		}
        print(n - 1);
		System.out.print(n+" ");
		
	}

}
// Recurrence relation T(n) = T(n-1)+1  ===> O(N)
//https://www.youtube.com/watch?v=4V30R3I1vLI