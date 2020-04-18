import java.util.*;
import java.io.*;
public class _06KthLargestElement{
	//Approach 1 Sort the Array Time Complexity O(n log n ) Space : O(1)
	public static int kthLargest(int arr[], int k) {
	  Arrays.sort(arr);
      return arr[arr.length-k];
	}
	//Approach 2 Using Min Priority  Queue T : O(n log k ) S : O(k)
	public static int kthLargest_2(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0;
		while(i < k )
			pq.offer(arr[i++]);
		while(i < arr.length){
			if(pq.peek() < arr[i]){
				pq.poll();
				pq.offer(arr[i]);
			}
			i++;
		}
		return pq.poll();
	}
	/*Approch 3 O(k + (n-k)*Logk)
	This approach is similar to the approach2 the  only differnec is that we will make our own
	build heap function as for k element in the O(k) time
	https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
	*/
	/*
	//Approach 4 : Average time : O(n)

	https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/

	Approach 5 : worst time : O(n)
	 https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/
	*/
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0 ;i< n;i++)
			arr[i] = Integer.parseInt(strArr[i]);
		int k = Integer.parseInt(br.readLine());
		System.out.println(kthLargest_2(arr,k));
	}
}