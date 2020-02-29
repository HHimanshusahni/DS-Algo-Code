import java.io.*;
public class AllIndicesOfANumber{

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

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String arr[] = br.readLine().split(" ");
		for(int i =0;i<n;i++)
			input[i] = Integer.parseInt(arr[i]);
		int x = Integer.parseInt(br.readLine());
		int ansArr [] = allIndexes(input,x);

		for(int ans:ansArr)
			System.out.print(ans+" ");

	}
}