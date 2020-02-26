import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class PrintAllSubStrings{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		printSubStrings2(str);
	}
	// approach 1
	public static void printSubStrings(String str){
		for(int i = 0;i<str.length();i++){
			for(int j = i+1;j<=str.length();j++){
				System.out.println(str.substring(i,j));
			}
		}
	}
	// approach 2
	public static void printSubStrings2(String str){
		for(int k = 1;k<=str.length();k++){
			int i = 0;
			while(i+k<=str.length()){
				System.out.println(str.substring(i,i+k));
				i++;
			}
		}
	}
}