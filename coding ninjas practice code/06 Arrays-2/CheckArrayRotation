import java.io.*;
public class CheckArrayRotation{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String str = br.readLine();
		String strArr[] = str.split(" ");
		for(int i = 0 ;i<n;i++)
			arr[i] = Integer.parseInt(strArr[i]);
		System.out.println(checkArrayRotation(arr));
	}
	public static int checkArrayRotation(int arr[]){

		for(int i = 1;i<arr.length;i++)
			if(arr[i]<arr[i-1])
				return i;
		return 0;

	}
}