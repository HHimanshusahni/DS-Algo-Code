import java.io.*;
public class Sort012{
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String str = br.readLine();
		String strArr[] = str.split(" ");
		for(int i = 0;i<n;i++)
			arr[i] = Integer.parseInt(strArr[i]);

		sort012(arr);
		for(int i = 0;i<n;i++)
			System.out.print(arr[i]+" ");

	}
	public static void sort012(int arr[]){
		int l =0,m=0,h=arr.length-1;
		while(m<=h){
			if(arr[m]==0){
				swap(m,l,arr);
				l++;
				m++;
			}else if(arr[m]==2){
				swap(m,h,arr);
				h--;
			}else {
				m++;
			}
		}
	}
	private static void swap(int i1,int i2,int arr[]){
		int t = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = t;
	}
}