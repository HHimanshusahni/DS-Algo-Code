import java.io.*;
import java.util.*;
public class  _04KLaregestElements{

	//Time Complexity : O ( n log k ) Space : O(k)
	public static ArrayList<Integer> kLargest(int input[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		while( i < k ){
			pq.offer(input[i]);
			i++;
		}
		while(i< input.length){
			if(pq.peek() < input[i]){
				pq.poll();
				pq.offer(input[i]);
			}
			i++;
		}
		while( !pq.isEmpty()){
			list.add(pq.poll());
		}
		return list;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String strInput[] = br.readLine().split(" ");
		for(int i = 0 ;i<n;i++){
			input[i] = Integer.parseInt(strInput[i]);
		}	
		int k =  Integer.parseInt(br.readLine());
		ArrayList<Integer> list  = kLargest(input,k);
		for(int item : list)
			System.out.print(item+" ");

	}
}