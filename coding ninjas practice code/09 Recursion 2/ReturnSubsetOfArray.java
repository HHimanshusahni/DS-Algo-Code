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
	// Approach2  [15|,20,12]
	public static int[][] subsets_2(int input[]) {
		return subsets_2(input,0);
	}
	public static int[][] subsets_2(int input[],int index){
		//Base Case
		if(input.length == index){
			int output[][] = new int[1][0];
			return output;
		}
		// Recursive Case
		int smallAns [][] = subsets_2(input,index+1);
		int ans [][] = new int[2*smallAns.length][];

		// Including the smallAns as it is in the mainAns
		for(int i = 0;i<smallAns.length;i++){
			ans[i] = new int[smallAns[i].length];
			for(int j = 0;j<smallAns[i].length;j++){
				ans[i][j] = smallAns[i][j];
			}
		}
		// Including the current index value with smallAns 
		for(int i = 0;i<smallAns.length;i++){
			ans[i+smallAns.length] = new int[smallAns[i].length+1];
			ans[i+smallAns.length][0] = input[index];
			for(int j = 0;j<smallAns[i].length;j++){
				ans[i+smallAns.length][j+1] = smallAns[i][j];
			}
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
		int ans [][] = subsets_2(input);
		for(int i = 0;i<ans.length;i++){
			for(int j = 0;j<ans[i].length;j++)
				System.out.print(ans[i][j]+" ");
			System.out.println();
		}


	}
}