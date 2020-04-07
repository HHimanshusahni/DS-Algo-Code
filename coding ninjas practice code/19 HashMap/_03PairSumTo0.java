import java.io.*;
import java.util.*;
public class _03PairSumTo0{
	//Approach 1 //O(n^2)
	public static void PairSum_1(int[] input, int size) {
		for(int i = 0;i<size;i++){
			int x = input[i];
			for(int j = i+1 ;j<size;j++){
				if(input[j] == -x){
					System.out.println(Math.min(x,-x)+" "+Math.max(-x,x));
				}
			}
		}
	}
	//Approach 2 O(nlog n) Sorting approch
	public static void PairSum_2(int[] input, int size) {
		Arrays.sort(input);
		int i = 0, j = size - 1;
		int first = 1, second = 1;
		while(i < j){ 
			if(input[i] + input[j] < 0){
				i++;
			}else if(input[i] + input[j] > 0){
				j--;
			}else{
			  first = 1;
			  second = 1;
			  while(input[i] == input[i+1]){
			  	first++;
			  	i++;
			  }
			  while(input[j] == input[j-1]){
			  	second++;
			  	j--;
			  }
			  for(int k = 1;k<=first * second ;k++)
			  	 System.out.println(input[i]+" "+input[j]);
			  	i++;
			  	j--;
			}
		}
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int input[] = new int[size];
		String sArr[] = br.readLine().split(" ");
		for(int i = 0;i<size;i++)
			input[i] = Integer.parseInt(sArr[i]);
		PairSum_2(input,size);
	}
}