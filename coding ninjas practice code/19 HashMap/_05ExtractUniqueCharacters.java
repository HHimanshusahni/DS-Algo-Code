import java.util.*;
import java.io.*;
public class _05ExtractUniqueCharacters{
	//Approach 1 O(n^2)
	public static String uniqueChar(String str){
		String ans = "";
		boolean flag ;
		for(int i = 0;i<str.length();i++){
			flag = true;
			for(int j = 0 ;j < i; j++){
				if(str.charAt(j) == str.charAt(i)){
					flag = false;
					break;
				}
			}
			if(flag)
			   ans = ans + str.charAt(i);
		}
		return ans;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(uniqueChar(str));
	}
}