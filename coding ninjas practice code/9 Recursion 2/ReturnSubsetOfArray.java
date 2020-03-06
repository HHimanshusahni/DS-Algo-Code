import java.io.*;
public class ReturnSubsetOfArray{
	// Appraoch1   [15,20,|12]
	public static int[][] subsets(int input[]) {
		return subsets(input,input.length-1);
	}
	public static int[][] subsets(int input[],int index) {
		//Base Case
		if(index == -1){
			int ans[][] = new int [1][0];
			return ans; 
		}
		//Recursive Case
		int smallAns[][] = subsets(input,index-1);

		// Small Calculation
		int ans [][] = new int[smallAns.length*2][];

		for(int i = 0,k = 0;i<smallAns.length;i++,k +=2){
			ans[k] = new int[smallAns[i].length];
			ans[k+1] = new int[smallAns[i].length+1];
			int j = 0;
			for(j =0;j<smallAns[i].length;j++){
				ans[k][j] = smallAns[i][j];// Don't include the current value in the ans
				ans[k+1][j] = smallAns[i][j];
				
			}
			ans[k+1][j] = input[index];// Include the current value in the ans
		}

		return ans;


	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String arr[] = br.readLine().split(" ");
		for(int i = 0 ;i<n;i++)
			input[i] = Integer.parseInt(arr[i]);
		int ans [][] = subsets(input);
		for(int i = 0;i<ans.length;i++){
			for(int j = 0;j<ans[i].length;j++)
				System.out.print(ans[i][j]+" ");
			System.out.println();
		}


	}
}