import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
public class SplitArray{

	public static boolean splitArray(int input[]) {
		int sum5 = 0,sum3 = 0;
		ArrayList <Integer>list = new ArrayList<Integer>();
		int totalSum = 0;
		for(int i = 0;i<input.length;i++){// O(n)  //Extra space 0(n)
			if(input[i]%5 == 0){
				sum5 += input[i];
			}else if(input[i]%3 == 0 ){
				sum3 += input[i];
			}else{
				// Separate elements
				list.add(input[i]);
				totalSum +=input[i];
			}
		}
		
		return splitArray(sum3,sum5,totalSum,list,0,0);

	}
	// Recurrence = 2T(n-1)+1 ==> By Masters theorem of decreasing function ==> Time Comp = 0(2^n)
	public static boolean splitArray(int sum3, int sum5,int totalSum,ArrayList<Integer> list,int i,int subsetSum){
		//Base Case

		if(i == list.size()){
			int otherSum = totalSum -subsetSum;
			if((Math.min(sum3,sum5)+Math.max(otherSum,subsetSum)) ==
			   (Math.max(sum3,sum5)+Math.min(otherSum,subsetSum)))
				return true;
			else 
				return false;
		}
		return splitArray(sum3,sum5,totalSum,list,i+1,subsetSum+list.get(i)) ||
		   	   splitArray(sum3,sum5,totalSum,list,i+1,subsetSum);

	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0 ;i<N;i++)
			input[i] = Integer.parseInt(strArr[i]);
	 	System.out.println(splitArray(input));
	}
}
