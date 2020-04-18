import java.util.*;
public class _08RunningMedian{
	//Time Complexity: n log n Space Complexity: O(n)
	public static void runningMedian(int arr[]) {
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
		int element,median;
		for(int i = 0 ;i< arr.length;i++){
			element = arr[i];
			if(i == 0 || element <= maxPQ.peek())
				maxPQ.offer(element);
			else
				minPQ.offer(element);
			if(Math.abs(maxPQ.size() - minPQ.size()) > 1){
				if(maxPQ.size() > minPQ.size())
					minPQ.offer(maxPQ.poll());
				else
					maxPQ.offer(minPQ.poll());	
			}
			
			if(i % 2 == 0 ){//means odd no of the elements till now so print the middle value
				if(maxPQ.size() > minPQ.size())
					median = maxPQ.peek();
				else 
					median = minPQ.peek();
			}else{ //Since the even no of the elements till now the median is average of the min and max value
				median = (minPQ.peek() + maxPQ.peek())/2;
			}
			System.out.println(median);
		}
	}
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0 ;i<n;i++)
			arr[i] = s.nextInt();
		runningMedian(arr);
	}
}