import java.io.*;
public class ReturnPermutationOfAString{
	public static String[] permutationOfString(String input){
		// Base case
		if(input.length() ==0){
			String output[] = new String[0];
			return output;
		}
		if(input.length() == 1){
			String output[]  = new String[1];
			output[0]  = input;
			return output;
		}

		//Recursive Case
		String[] smallAns = permutationOfString(input.substring(1));

		//Small Calculation
		String ans [] = new String[smallAns.length * input.length()];
		for(int i = 0,counter = 0;i<smallAns.length;i++){
			String str = smallAns[i];
			char ch = input.charAt(0);
			for(int j = 0;j<=str.length();j++){
				ans[counter++] = str.substring(0,j)+ch+str.substring(j);  // important line showing use of substring method
			}

		}

		return ans;
	}
// Approach 2
	public static String[] permutationOfString_2(String input){
		//base case
		if(input.length() == 0){
			String output[] = new String[0];
			return output;
		}
		if(input.length() == 1){
			String output[] = {input};
			return output;
		}
		// Recursive case
		int fact = 1;
		for(int i = 1;i<=input.length();i++)
				fact = i*fact;
		int counter = 0 ;
		String ans[] = new String[fact];
		for(int i =0;i<input.length();i++){
			String smallAns[] = permutationOfString_2(input.substring(0,i)+input.substring(i+1));
			for(int j = 0;j<smallAns.length;j++){
				ans[counter++] = input.charAt(i)+ smallAns[j];
			}

		}
		return ans;

	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ans [] = permutationOfString_2(br.readLine());

		for(String str : ans)
			System.out.println(str);
	}
}