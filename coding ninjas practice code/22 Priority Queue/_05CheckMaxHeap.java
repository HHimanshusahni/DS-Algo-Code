import java.util.*;
import java.io.*;
public class _05CheckMaxHeap{
	//Recursive Approach
	public static boolean checkMaxHeap(int arr[]) {
		return checkMaxHeap(arr,0);
	}
	public static boolean checkMaxHeap(int arr[],int parentIndex) {
		//Base Case
		if(parentIndex >= arr.length)
			return true;
		int parent = arr[parentIndex];
		int leftChild = Integer.MIN_VALUE;
		int rightChild = Integer.MIN_VALUE;
		int leftChildIndex = 2 * parentIndex + 1;
		int rightChildIndex = 2 * parentIndex + 2;

		if(leftChildIndex < arr.length)
			leftChild = arr[leftChildIndex];
		if(rightChildIndex < arr.length)
			rightChild = arr[rightChildIndex];

		if(parent < leftChild || parent < rightChild)
			return false;
		return checkMaxHeap(arr,leftChildIndex) && checkMaxHeap(arr,rightChildIndex);
	}

	//Approach 2 Iterative Time: O(n) Space : O(1)
	public static boolean checkMaxHeap_2(int arr[]) {
			
		for(int i = 0 ;i<arr.length;i++){
			if(2*i +1 >= arr.length)
				break;
			if(arr[i] < arr[2*i +1])
			 	return false;

			if(2*i +2  >= arr.length)
				break;

			if(arr[i] < arr[2*i +2]) 
				return false;
		}
		return true;
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr [] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			arr[i] = Integer.parseInt(strArr[i]);
		System.out.println(checkMaxHeap_2(arr)+" ");
	}
	
}