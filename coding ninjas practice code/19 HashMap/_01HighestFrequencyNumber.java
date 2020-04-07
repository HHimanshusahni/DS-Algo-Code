import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class _01HighestFrequencyNumber{
	public static int maxFrequencyNumber(int[] arr){//Time Complexity O(n) & Space O(n)

		HashMap<Integer,Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int maxKey = 0;
		for(int i = 0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i],map.get(arr[i])+1);
			}
			else{
				map.put(arr[i],1);
			}
			if(map.get(arr[i])>max){
				max = map.get(arr[i]);
				maxKey = arr[i];
			}
		}
		return maxKey;
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String sArr[] = br.readLine().split(" ");
		for(int i = 0;i < n;i++)
			arr[i] = Integer.parseInt(sArr[i]);
		System.out.println(maxFrequencyNumber(arr));
	}

}