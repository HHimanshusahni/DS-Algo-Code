import java.io.*;
class PrintAllCodes{
	public static void printAllPossibleCodes(String input){
		printAllPossibleCodes(input,"");
	}
	public static void printAllPossibleCodes(String input, String outputSoFar){
		//Base Case
		if(input.length() == 0){
			System.out.println(outputSoFar);
			return;
		}

		int numericValue1 = input.charAt(0)-'0';
		char attach1 = getCharFromNum(numericValue1);
		printAllPossibleCodes(input.substring(1),outputSoFar+attach1); //Recursive Call

		if(input.length ()>=2){
			int numericValue2 = input.charAt(1) - '0';
			numericValue2 = numericValue1 *10 + numericValue2;
			if(numericValue2 <=26){
				char attach2 = getCharFromNum(numericValue2);
				printAllPossibleCodes(input.substring(2), outputSoFar+attach2);//Recursive Call
			}
		}
		
	}
	private static char getCharFromNum(int num){
		char ch = (char)('a' +num - 1);
		return ch;
	}
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
	    printAllPossibleCodes(input);

	}
}