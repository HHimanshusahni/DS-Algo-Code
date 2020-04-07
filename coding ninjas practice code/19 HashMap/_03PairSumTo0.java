import java.io.*;
import java.util.*;
public class _03PairSumTo0{
	//Approach 1 //O(n^2)
	public static void PairSum_1(int[] input, int size) {
		for(int i = 0;i<size;i++){
			int x = input[i];
			for(int j = i+1 ;j<size;j++){
				if(input[j] == -x){
					System.out.println(Math.min(x,-x)+" "+Math.max(-x,x));
				}
			}
		}
	}
	//Approach 2 O(nlog n) Sorting approch
	public static void PairSum_2(int[] input, int size) {
		Arrays.sort(input);
		int i = 0, j = size - 1;
		int first = 1, second = 1;
		while(i < j){ 
			if(input[i] + input[j] < 0){
				i++;
			}else if(input[i] + input[j] > 0){
				j--;
			}else{
			  first = 1;
			  second = 1;
			  while(input[i] == input[i+1]){
			  	first++;
			  	i++;
			  }
			  while(input[j] == input[j-1]){
			  	second++;
			  	j--;
			  }
			  for(int k = 1;k<=first * second ;k++)
			  	 System.out.println(input[i]+" "+input[j]);
			  	i++;
			  	j--;
			}
		}
	}
	//Approach 3 O(n) space O(n)time
	public static void PairSum_3(int[] input, int size) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i : input){
			if(map.containsKey(i))
				map.put(i,map.get(i)+1);
			else
				map.put(i,1);
		}
		int firstCount ,secondCount;
		for(int i :input){
			if(map.containsKey(i) && map.containsKey(-i)){
				firstCount = map.get(i);
				secondCount = map.get(-i);
				for(int j = 1; j <= firstCount * secondCount; j++){
					System.out.println(Math.min(i,-i)+" "+Math.max(i,-i));
				}
				map.remove(i);
				map.remove(-i);
			}
		}
	}
	//Approach 4: Optimization of approach 3 O(n) space O(n)time but need to do only one scan rather than 2 scans
	public static void PairSum_4(int[] input, int size) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int count ;
		for(int i : input){
			if(map.containsKey(-i)){
				 count = map.get(-i);
				 for(int j = 0;j<count;j++){
				 	System.out.println(Math.min(i,-i)+" "+Math.max(i,-i));
				 }
			}
			if(map.containsKey(i)){
				map.put(i,map.get(i)+1);
			}else
				map.put(i,1);
		}
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int input[] = new int[size];
		String sArr[] = br.readLine().split(" ");
		for(int i = 0;i<size;i++)
			input[i] = Integer.parseInt(sArr[i]);
		PairSum_4(input,size);
	}
}