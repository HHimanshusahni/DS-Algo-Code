import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class _06LongestConsequtiveSequence{
/*	Approach 1
	In worst case for the n elements of size 1 we have to check the copy array 
	time : O(n^2)
	Space : O(n) for copy array and temp arraylist 
*/	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		int arrCopy[] = arr.clone();
		Arrays.sort(arr);//O(n log n)
		ArrayList<Integer> currentAns = new ArrayList<>(),tempAns;
		for(int i = 0;i<arr.length;i++){
			tempAns = new ArrayList<>();
			tempAns.add(arr[i]);
		
			while(i+1 < arr.length ){
				if(arr[i]+1 == arr[i+1]){
					tempAns.add(arr[i+1]);
					i++;
				}
				else if(arr[i+1] == arr[i]){
						i++;
				}else
					break;
				
			}
			if(currentAns.size() < tempAns.size()){
				currentAns = tempAns;
			}else if( currentAns.size() == tempAns.size()){
				if(comesFirst(tempAns.get(0),currentAns.get(0),arrCopy))
					currentAns = tempAns;
			}

		}
		return currentAns;
	}
	public static boolean comesFirst(int first, int second , int arr[]){//O(n)
		for(int i = 0 ;i  < arr.length; i++)
			if(arr[i] == first)
				return true;
			else if(arr[i] == second)
				return false;
		return true;
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String sArr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			arr[i] = Integer.parseInt(sArr[i]);
		ArrayList<Integer> list = longestConsecutiveIncreasingSequence(arr);
		for(int i : list)
			System.out.print(i+" ");
	}
}