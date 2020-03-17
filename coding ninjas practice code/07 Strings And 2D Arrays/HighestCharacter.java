import java.io.*;
public class HighestCharacter{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(highestOccuringCharacter_2(str));
	}
	static final int ASCII_SIZE = 256;
	public static char highestOccuringCharacter_2(String str){
		int freq [] = new int[ASCII_SIZE];
		// scanning the string and putting the frequency in the frequency array
		for(int i =0;i<str.length();i++){
			char ch = str.charAt(i);
			freq[ch]++;
		}
		char maxChar = 0 ;
		int max =-1;
		// again scanning the string to find the max char frequency value which occured first
		for(int i =0;i<str.length();i++){
			char ch = str.charAt(i);
			if(freq[ch]>max){
				maxChar = ch;
				max = freq[ch];
			}
		}
		return maxChar;
	}

	// code falis for the input baab o/p should  be b but it gives o/p a
	public static char highestOccuringCharacter(String str){
		int freq [] = new int[256];
		char maxChar = 0 ;
		int max = -1;
		for( int i = 0;i<str.length();i++){
			char ch = str.charAt(i);
			freq[ch]++;
			if(freq[ch]>max){
				max = freq[ch];
				maxChar = ch;
			}
		}
		return maxChar;

    }
}