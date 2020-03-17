import java.io.*;
public class MaximizeTheSum{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String strArr[] = str.split(" ");
		int arr1[] = new int[M];
		for(int i = 0;i<M;i++){
			arr1[i] = Integer.parseInt(strArr[i]);
		}

		int N = Integer.parseInt(br.readLine());
	    str = br.readLine();
		String strArr2[] = str.split(" ");
		int arr2[] = new int[N];
		for(int i = 0;i<N;i++){
			arr2[i] = Integer.parseInt(strArr2[i]);
		}
		long maxSum = maximumSumPath(arr1,arr2);
		System.out.println(maxSum);

	}


	public static long maximumSumPath(int[] input1, int[] input2){
		
		int i=0 , j=0,input1Sum = 0,input2Sum=0;
		long maxSum = 0;
		while(i<input1.length&&j<input2.length){
			
			if(input1[i]==input2[j]){
				maxSum += Math.max(input1Sum,input2Sum)+input1[i];
				i++;
				j++;
				input1Sum = 0;
				input2Sum = 0;
			}else if(input1[i]<input2[j]){
				input1Sum += input1[i];
				i++;
			}else {
				input2Sum +=input2[j];
				j++;
			}
		}
		while(i<input1.length){
			input1Sum += input1[i++];
		}
		while(j<input2.length){
			input2Sum +=input2[j++];
		}
		maxSum += Math.max(input1Sum,input2Sum);
		return maxSum;
	}

}