import java.io.*;
import java.util.ArrayList;
public class PrintSubsetSumToK{
	
	public static void printSubsetsSumTok(int input[], int k){
		ArrayList <Integer> outputSoFar = new ArrayList<>();
		printSubsetsSumTok(input,k,0,outputSoFar);
	}

	public static void printSubsetsSumTok(int input[], int k,int index,ArrayList<Integer> outputSoFar){
		//Base Case
		if(k == 0){
		  for(Integer i : outputSoFar)
			 	System.out.print(i+" ");
		  System.out.println();
     	  return;
		}
		if(k<0 || index == input.length)
			return;
		//Recursive Case
		ArrayList<Integer> outputSoFar2 = new ArrayList<Integer>(outputSoFar);
		outputSoFar2.add(input[index]);
		printSubsetsSumTok(input,k-input[index],index +1,outputSoFar2);
		printSubsetsSumTok(input,k,index +1,outputSoFar);
		
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String str[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			input[i] = Integer.parseInt(str[i]);
		int k = Integer.parseInt(br.readLine());
		printSubsetsSumTok(input,k);
	}
}