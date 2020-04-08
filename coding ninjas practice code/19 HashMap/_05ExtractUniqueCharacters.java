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

	//Approach 2  time : O(n) space : O(n) HashSet Approach
	public static String uniqueChar_2(String str){
		HashSet<Character> set = new HashSet<>();
		String ans = "";
		char c ;
		for(int i = 0;i<str.length();i++){
			c = str.charAt(i);
			if(!set.contains(c)){
				ans = ans+c;
				set.add(c);
			}
		}
		return ans;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(uniqueChar_2(str));
	}
}