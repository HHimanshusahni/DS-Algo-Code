import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException
public class PrintAllSubStrings{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		printSubStrings(str);
	}
	static void printSubStrings(String str){
		for(int i = 0;i<str.length;i++){
			for(int j = 0;j<=str.length;j++){
				System.out.println(str.substring(i,j));
			}
		}
	}
}