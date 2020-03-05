import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class PrintPermutationOfAString{
	public static void permutations(String input){
			permutations(input,"");
	}
	public static void permutations(String input,String outputSoFar){
		// Base Case
		if(input.length() == 0){
			System.out.println(outputSoFar);
			return;
		}

		//Recursive case
		for(int i = 0;i<input.length();i++){
			char ch = input.charAt(i);
			permutations(input.substring(0,i)+input.substring(i+1),outputSoFar + ch);
		}
	}

	// https://www.youtube.com/watch?v=GuTPwotSdYw
	// Approach 2
	public static void permutations_2(String input){
		char arr[] = input.toCharArray();
		permutations_2(arr,0,input.length()-1);
	}
	public static void permutations_2(char arr[],int l , int r){
		// Base Case
		if(l == r)
			System.out.println(String.valueOf(arr));
		else{
			// Recursive step
			for(int i = l;i<=r;i++){
				swap(arr,l,i);
				permutations_2(arr,l+1,r);
				swap(arr,l,i);// backtrack

			}
		}
	}
	private static void swap(char arr[],int index1 ,int index2){
		char temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		permutations(br.readLine());
	}
}