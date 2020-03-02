import java.io.*;
public class KeypadCombinations{
	public static final  String KEYS[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static String[] keypad(int n){
		// base case
		if(n/10 == 0){
			String [] output = KEYS[n].split("");
			// or 
			//String s = KEYS[n];
			//String [] output = new String[s.length()];
			//for(int i = 0;i<s.length();i++)
			//output[i] = s.charAt(i)+"";
			
			return output; 
		}

		// Recursive case
		String[] smallAns = keypad(n/10);

		// Small Calculation
		String str = KEYS[n%10];
		String ans [] = new String[str.length() * smallAns.length];

		for(int i = 0,counter=0;i<str.length();i++)
			for(int j = 0;j<smallAns.length;j++)
				ans[counter++] = smallAns[j]+str.charAt(i);
		
		return ans;


	}
	public static void main(String arg[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String ans[] = keypad(n);
		for(String a : ans)
			System.out.println(a);
	}
}