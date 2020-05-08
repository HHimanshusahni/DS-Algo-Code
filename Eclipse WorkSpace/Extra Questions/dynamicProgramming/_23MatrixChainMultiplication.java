package dynamicProgramming;
import java.io.*;
//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication/0
public class _23MatrixChainMultiplication {
	public static int mcm(int arr[],int i , int j ){
		//Base Case
		if(i >= j ) //When there is 1 element no  need to mutliply
			return 0 ;
		int minAns = Integer.MAX_VALUE;
		for(int  k = i ; k <= j-1 ;k++){
			int tempAns = mcm( arr,i,k)+
						  mcm(arr,k+1,j)+
						  arr[i-1] * arr[k]*arr[j];
			if(tempAns < minAns)
				minAns = tempAns;
		}
		return minAns;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t  = 0 ;t < test ;t++){
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			String strArr[] = br.readLine().split(" ");
			for(int i = 0 ;i < n;i++)
				arr[i] = Integer.parseInt(strArr[i]);
			System.out.println(mcm(arr,1,n-1));
		}
	}

}
