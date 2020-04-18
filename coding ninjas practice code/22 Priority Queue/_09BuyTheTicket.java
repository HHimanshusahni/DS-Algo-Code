import java.util.*;
public class _09BuyTheTicket{
	//Time Complexity : O(n^2) But not confirmed 
	//Space : O(n)
	public static int buyTicket(int input[], int k) {
		Queue<Integer> q = new LinkedList<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0 ;i<input.length;i++){
			q.offer(i);
			maxPQ.offer(input[i]);
		} 
		int counter = 0;
		while(true){
			int indexFront = q.poll();
			if(input[indexFront] == maxPQ.peek()){
				counter++;
				maxPQ.poll();
				if(indexFront == k )
					break;
			}else
				q.offer(indexFront);	
		}
		return counter;
	}
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0 ;i<n;i++)
			input[i] = s.nextInt();
		int k = s.nextInt();
		System.out.println(buyTicket(input,k));
	}
}