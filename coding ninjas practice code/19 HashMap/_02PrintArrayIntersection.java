import java.io.*;
import java.util.*;
public class _02PrintArrayIntersection{
	public static void intersection(int[] arr1, int[] arr2){//O(n+m) time & O(n)space n is size of array1 and m is size of array2
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i<arr1.length;i++){
			if(map.containsKey(arr1[i])){
				map.put(arr1[i],map.get(arr1[i])+1);
			}else{
				map.put(arr1[i],1);
			}
		}
		for(int i = 0;i<arr2.length;i++){
			if(map.containsKey(arr2[i])){
				System.out.println(arr2[i]+" ");
				int count = map.get(arr2[i]);
				if(count == 1)
					map.remove(arr2[i]);
				else
					map.put(arr2[i],count-1);
			}
		}
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr1 [] = new int[n];
		String sArr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)	
			arr1[i] = Integer.parseInt(sArr[i]);

	    n = Integer.parseInt(br.readLine());
		int arr2 [] = new int[n];
	    sArr = br.readLine().split(" ");
		for(int i = 0;i<n;i++)	
			arr2[i] = Integer.parseInt(sArr[i]);
		intersection(arr1,arr2);

	}
}