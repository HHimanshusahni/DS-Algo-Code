import java.io.*;
public class ReturnSubsetSumToK{
	public static int[][] subsetsSumK(int input[], int k){
		return subsetsSumK(input,k,0);

	}
	public static int[][] subsetsSumK(int input[], int k,int index){
	//	Base Case; 	//yeh base case mai error hai 
		if(k == 0){
			int output[][] = new int[1][0]; 
			 return output ;
		}
		if((k < 0) || input.length == index ){
			int output[][] = new int[0][0];
			 return output ;
		}
		
		
		// //Base case
		// if( input.length == index ){
			
	 //  		if(k == 0){
		// 		int output[][] = new int[1][0]; 
		// 		 return output ;
		// 	}
		// 	int output[][] = new int[0][0];
		// 	 return output ;
		// }
	
		 //Recursive Case
		int smallAns1 [][] = subsetsSumK(input,k,index+1);
		int smallAns2 [][] = subsetsSumK(input,k-input[index],index+1);

		//SmallCalculation
		int ans [][] =  new int[smallAns1.length+smallAns2.length][];
		int counter = 0;
		for(int i =0;i<smallAns1.length;i++){
			ans[counter] = new int[smallAns1[i].length];

			for(int j = 0;j<smallAns1[i].length;j++)
				ans[counter][j] = smallAns1[i][j];
			counter++;
		}
		for(int i =0;i<smallAns2.length;i++){
			ans[counter] = new int[smallAns2[i].length+1];
			ans[counter][0] = input[index];

			for(int j = 0;j<smallAns2[i].length;j++)
				ans[counter][j+1] = smallAns2[i][j];
			counter++;
		}
		return ans;
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input [] = new int[n];
		String arr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++){
			input[i] = Integer.parseInt(arr[i]);
		}
		int k = Integer.parseInt(br.readLine());
		int ans[][] = subsetsSumK(input,k);
		for(int i = 0;i<ans.length;i++){
			for(int j = 0;j<ans[i].length;j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}	
