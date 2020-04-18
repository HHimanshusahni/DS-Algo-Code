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