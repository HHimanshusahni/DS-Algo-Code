import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
/*	  Approach 2 : Using HashMap
	  time : O(n) 
	  space : O(n)
*/
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence_2(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>(),smallAns;
		for(int i = 0;i<arr.length;i++){
			set.add(arr[i]);
			map.put(arr[i],i);
		}
		for(int i = 0 ;i<arr.length;i++){
			smallAns = new ArrayList<>();
			if(set.contains(arr[i])){
				int x = arr[i];
				smallAns.add(x);
				set.remove(arr[i]);
				//Finding all the elements larger than arr[i]
				for(int j = x+1 ;set.contains(j);j++){
					set.remove(j);
					smallAns.add(j);//appends elements at the end of the list
				}
				//Finding all the elements smaller than arr[i]
				for(int j = x - 1;set.contains(j) ;j--){
					set.remove(j);
					smallAns.add(0,j);
				}

				if(ans.size()<smallAns.size()){
					ans = smallAns;
				}
				else if(ans.size() == smallAns.size()){
					if(map.get(ans.get(0)) > map.get(smallAns.get(0)) ){
						ans = smallAns;
					}
				}
				System.out.print("ans");
				for(int k = 0;k<ans.size();k++)
					System.out.print(ans.get(k)+" ");
				System.out.print("smallAns");
				for(int k= 0;k<smallAns.size();k++)
					System.out.print(smallAns.get(k)+" ");
				
				System.out.println();
			}
		}
		return  ans;
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String sArr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			arr[i] = Integer.parseInt(sArr[i]);
		ArrayList<Integer> list = longestConsecutiveIncreasingSequence_2(arr);
		for(int i : list)
			System.out.print(i+" ");
	}
}