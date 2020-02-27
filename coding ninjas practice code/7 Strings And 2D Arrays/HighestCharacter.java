import java.io.*;
public class HighestCharacter{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(highestOccuringCharacter(str));
	}

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