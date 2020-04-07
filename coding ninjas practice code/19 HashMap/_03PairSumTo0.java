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
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int input[] = new int[size];
		String sArr[] = br.readLine().split(" ");
		for(int i = 0;i<size;i++)
			input[i] = Integer.parseInt(sArr[i]);
		PairSum_1(input,size);
	}
}