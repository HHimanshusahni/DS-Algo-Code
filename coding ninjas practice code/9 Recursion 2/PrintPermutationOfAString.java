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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		permutations(br.readLine());
	}
}