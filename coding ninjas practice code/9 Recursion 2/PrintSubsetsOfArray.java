import java.io.*;
import java.util.ArrayList;
public class PrintSubsetsOfArray{
	public static void printSubsets(int input[]) {
		int arr[] = new int[0];
		printSubsets(input,arr,0);
	}
	public static void printSubsets(int input[],int outputSoFar[],int index) {
		//Base Case
		if(input.length == index){
			for(int i :outputSoFar)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		//Small Calculation
		int ans[] = new int[outputSoFar.length+1];
	
		for(int i = 0;i<outputSoFar.length;i++){
			ans[i] = outputSoFar[i];
		}
		ans[ans.length-1] = input[index];
		// Recursive Case
		//We don't include the current element in the ans
			printSubsets(input,outputSoFar,index+1);
		//We include the current element in the answer
			printSubsets(input,ans,index+1);

	}

	// Approach 2 by using arraylist 
	public static void printSubsets_2(int input[]) {
		ArrayList<Integer> list = new ArrayList<>();
		printSubsets_2(input,list,0);
	}
	public static void printSubsets_2(int input[],ArrayList<Integer> outputSoFar,int index) {
		//Base Case
		if(input.length == index){
			for(int i :outputSoFar)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		// Recursive Case
		//We don't include the current element in the ans
			printSubsets_2(input,outputSoFar,index+1);
		//We include the current element in the answer
			ArrayList<Integer> outputSoFar2 = new ArrayList<>(outputSoFar);
			outputSoFar2.add(input[index]);
			printSubsets_2(input,outputSoFar2,index+1);

	}
	public static void main(String[] args)throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String arr[] = br.readLine().split(" ");
		int input[] = new int[n];
		for(int i = 0;i<n;i++){
			input[i] = Integer.parseInt(arr[i]);
		}
		printSubsets_2(input);
	}
}