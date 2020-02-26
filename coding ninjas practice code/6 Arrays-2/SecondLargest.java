import java.io.*;
public class SecondLargest{
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String strArr[] = str.split(" ");
		int input[] = new int[n];
		for(int i = 0;i<n;i++){
			input[i] = Integer.parseInt(strArr[i]);
		}
		System.out.println(findSecondLargest(input));

	}

	public static int findSecondLargest(int arr[]){
		if(arr.length<=1)
			return Integer.MIN_VALUE;
		int l = arr[0];
		int sl = Integer.MIN_VALUE;
		for(int i = 1;i<arr.length;i++){
			if(arr[i]>l){
				sl = l;
				l = arr[i];
			}else if(arr[i]>sl){
				sl = arr[i];
			}
		}
		return sl;
	}
}