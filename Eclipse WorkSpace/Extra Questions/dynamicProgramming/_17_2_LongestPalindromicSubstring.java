package dynamicProgramming;
import java.io.*;
import java.util.*;
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
public class _17_2_LongestPalindromicSubstring {
	//Time Complexity : O(n^2)
	public static String LPS(String s){
		int n = s.length();
		int palindrome_begin = 0;
		int max_len = 1;
		boolean palindrome[][] = new boolean[n][n];

		//single letter is a palindrome always
		for(int i = 0 ;i < n; i++){
			palindrome[i][i] = true;
		}
		//palindrome of two chracters
		for(int i  = 0 ;i < n -1 ;i++){
			if(s.charAt(i) == s.charAt(i+1)){
				palindrome[i][i+1] = true;
				if(max_len == 1){
					palindrome_begin= i;
					max_len = 2;
				}
			}
		}
		//finding palindrome of length 3 and saving longest
		for(int length = 3 ; length <= n;length++){
			for(int i = 0 ;i < n - length+1;i++){
				int j = i + length - 1;
				if(s.charAt(i) == s.charAt(j)
						&& palindrome[i+1][j-1]){
					palindrome[i][j] = true;
					if(max_len < length){
						palindrome_begin = i;
						max_len = length;
					}
				}
			}
		}
		return s.substring(palindrome_begin,palindrome_begin+max_len);
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ;i < t; i++){
			String s = br.readLine();
			System.out.println(LPS(s));
		}
	}
}

