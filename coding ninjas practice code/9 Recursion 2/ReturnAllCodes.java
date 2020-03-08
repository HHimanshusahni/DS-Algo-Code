import java.io.*;
public class ReturnAllCodes{
	// Recursion  Approach  S|tring  and St|ring
	public static  String[] getCode(String input){
		// Base Case
		if(input.length() == 1){
			String arr[] = new String[1];
			char ch = getChar(input.charAt(0)-'0');
		    arr[0] = ch +"";
			return arr;
		}
		if(input.length() == 0){
			String arr[] = new String[1];
			arr[0] = "";
			return arr;
		}
		String [] smallAns1 = getCode(input.substring(1));//Recursive Case
		String [] smallAns2 = new String[0];
	
		int numberValue1 = input.charAt(0)-'0';
		char attach1 = getChar(numberValue1);
		char attach2 = 0;
		int numberValue2 =  input.charAt(1)-'0';
		numberValue2 = numberValue1*10 + numberValue2;
		if(numberValue2<=26){	
			attach2 = getChar(numberValue2);
			smallAns2 = getCode(input.substring(2));//Recursive Case
		}	

		String[] ans = new String[smallAns1.length + smallAns2.length];

		int counter = 0;
		for(int i = 0;i<smallAns1.length;i++)
				ans[counter++] = attach1 + smallAns1[i];	
		
		for(int i = 0;i<smallAns2.length;i++)
			ans[counter++] = attach2+smallAns2[i];
		
		return ans;
	}
	private static char getChar(int num){
		char ch =  (char)('a' + num - 1);
		return ch;
	}
		public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ans[] = getCode(br.readLine());
		for(String str: ans)
			System.out.println(str);
	}
}
