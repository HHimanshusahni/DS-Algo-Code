import java.io.*;
import java.util.*;
public class _07PairsWithDifferenceK{
	
	//Approach 1 O(n^2)
	public static void findPairsDifferenceK(int[] input, int k){
		for(int i = 0;i<input.length;i++){
			for(int j = i+1;j<input.length;j++){
				if(Math.abs(input[i]-input[j]) == k)
					System.out.println(Math.min(input[i],input[j])+" "+ Math.max(input[i],input[j]));
			}
		}
	}
	//Approach 2 O(nlog n ) sorting approach
	public static void findPairsDifferenceK_2(int[] input, int k){
		Arrays.sort(input);
		int i = 0,j = i+1;
		int countFirst ,countSecond , count ,counter;
		while(j<input.length){
			if((input[j] - input[i]) == k){
				if(input[j] == input[i]){
					counter = 2;
					while(j+1<input.length && input[j] == input[j+1]){
						j++;
						counter++;
					}
					i = j -1;
					count = ( counter * (counter - 1))/2;

				}else{
					countFirst = 1;
					countSecond = 1;
					while(i+1<input.length && input[i] == input[i+1]){
						i++;
						countFirst++;
					}
					while(j+1 <input.length &&input[j] == input[j+1]){
						j++;
						countSecond++;
					}
					count = countFirst * countSecond;
				}
				for(int l = 0;l<count;l++)
					System.out.println(input[i] +" "+input[j]);
				i++;
				j++;
			}else if((input[j]- input[i]) > k){
				i++;
				if(i == j)
					j++;
			}else {
				j++;
			}
		}
	}
	//Approach 3 Time : O(n) , Space: O(n)
	public static void findPairsDifferenceK_3(int[] input, int k){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i<input.length;i++){
			if(map.containsKey(input[i]))
				map.put(input[i],map.get(input[i])+1);
			else
				map.put(input[i],1);
		}
		int count1 ,count2;
		for(int i = 0;i<input.length;i++){
			int val = input[i];
			if(map.containsKey(val)){
			    count1 = map.get(val);
			    if(k == 0 && count1 > 1){
			    	for(int j = 0;j<( count1 * (count1 -1) )/2;j++)
			    		System.out.println(val +" "+val);
			  
			    }else{
				     if(map.containsKey(val - k)){
						 count2 = map.get(val -k);
						for(int j = 0;j<count1 * count2;j++)
							System.out.println(Math.min(val,val - k)+" "+Math.max(val,val-k));
					}
					if(map.containsKey(val +k)){
					    count2 = map.get(val+k);
						for(int j = 0;j<count1 * count2; j++)
							System.out.println(Math.min(val,val + k)+" "+Math.max(val,val + k));
					}
			    }
			
				map.remove(val);
			}
		}
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			input[i] = Integer.parseInt(strArr[i]);
		int k = Integer.parseInt(br.readLine());
		findPairsDifferenceK_3(input,k);
	}
}