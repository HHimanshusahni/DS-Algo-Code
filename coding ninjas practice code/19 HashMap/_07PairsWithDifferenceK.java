import java.io.*;
import java.util.*;
public class _07PairsWithDifferenceK{
	
	//Approach 1 O(n^2)
	public static void findPairsDifferenceK(int[] input, int k){
		for(int i = 0;i<input.length;i++){
			for(int j = i+1;j<input.length;j++){
				if(Math.abs(input[i]-input[j]) == k)
					System.out.println(Math.min(input[i],input[j])+" "+ Math.max(input[i],input[j]));
			}
		}
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			input[i] = Integer.parseInt(strArr[i]);
		int k = Integer.parseInt(br.readLine());
		findPairsDifferenceK(input,k);
	}
}