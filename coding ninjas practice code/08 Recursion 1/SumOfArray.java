import java.io.*;
public class SumOfArray{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String arr[] = br.readLine().split(" ");
		for(int i = 0;i<arr.length;i++){
			input[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(sum_2(input));
	}

	// approach 1 
	public static int sum(int input[]) {
		return sum(input,0);
	}
	public static int sum(int input[],int index){
		if(index==input.length)
			return 0;
		return input[index]+sum(input,index+1);
	}



	// approach 2
	public static int sum_2(int input[]){
		return sum_2(input, input.length-1);
	}	
	public static int sum_2(int input[],int index){
		if(index == -1)
			return 0;
		return (input[index] + sum_2(input,index-1));
	}
	
}