import java.io.*;
public class BubbleSort{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String str = br.readLine();
		String strArr[] = str.split(" ");
		for(int i =0;i<n;i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		Solver solver = new Solver();
		solver.bubbleSort(arr);
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
class Solver{
	void bubbleSort(int arr[]){
		int n = arr.length;
		for(int i = 0;i<n-1;i++){
			boolean flag = true;
			for(int j =0;j<n-1-i;j++){
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag)
				break;
			
		}
	}
}