import java.util.*;
import java.io.*;
public class _06KthLargestElement{
	//Approach 1 Sort the Array Time Complexity O(n log n ) Space : O(1)
	public static int kthLargest(int arr[], int k) {
	  Arrays.sort(arr);
      return arr[arr.length-k];
	}
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0 ;i< n;i++)
			arr[i] = Integer.parseInt(strArr[i]);
		int k = Integer.parseInt(br.readLine());
		System.out.println(kthLargest(arr,k));
	}
}