import java.io.*;
public class AllIndicesOfANumber{
	//Approach 1 //Time Complexity : 0(n)  as T(n) = T(n-1)+1
	public static int[] allIndexes(int input[],int x){
		int arr[] = new int[1000];
		int solIndex = allIndexes(input,arr,0,0,x);
		int solArr[] = new int[solIndex];
		for(int i=0;i<solIndex;i++){
			solArr[i] = arr[i];
		}
		return solArr;
	}

	public static int allIndexes(int input[],int arr[] ,int index ,int solIndex,int x ){
		if(index == input.length)
			return solIndex;
		if(input[index] == x )
			arr[solIndex++] = index;
		return allIndexes(input,arr,index+1,solIndex,x);
	}

	// Approach 2 Recurrence Relation : T(n) = T(n-1)+n Time complexity = 0(n^2)
	public static int[] allIndexes_2(int input[],int x){
		return allIndexes_2(input,x,0);
	}
	public static int[] allIndexes_2(int input[],int x,int index){
		//base case
		if(index ==input.length){
			int output[] = new int[0];
			return output;
		}
		// recursive step
		int [] smallAns = allIndexes_2(input,x,index+1);

		//our work
		if(input[index] == x){
			int ans [] = new int[smallAns.length+1];
			ans[0] = index;
			for(int i =0;i<smallAns.length;i++){
				ans[i+1] = smallAns[i];
			}
			return ans;
		}
		return smallAns;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String arr[] = br.readLine().split(" ");
		for(int i =0;i<n;i++)
			input[i] = Integer.parseInt(arr[i]);
		int x = Integer.parseInt(br.readLine());
		int ansArr [] = allIndexes_2(input,x);

		for(int ans:ansArr)
			System.out.print(ans+" ");

	}
}